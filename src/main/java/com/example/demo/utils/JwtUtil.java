
package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class JwtUtil {
    private static final String secret = "Chen2002"; // 令牌加密密钥
    private static final Long expiration = 1209600L; // 令牌过期时长（秒）

    /**
     * 生成用户token,设置token超时时间
     *
     * @param name 用户名
     * @return 生成的token
     */
    public static String createToken(String name) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + expiration * 1000); // 计算过期时间
        Map<String, Object> map = new HashMap<>(); // 创建头部信息map
        map.put("alg", "HS256"); // 添加算法信息
        map.put("typ", "JWT"); // 添加令牌类型信息
        String token = JWT.create()
                // 添加头部
                .withHeader(map)
                //可以将基本信息放到claims中
                //userName
                .withClaim("userName", name) // 添加用户名信息到令牌中
                //超时设置,设置过期的日期
                .withExpiresAt(expireDate) // 设置令牌过期时间
                //签发时间
                .withIssuedAt(new Date()) // 设置令牌签发时间
                //SECRET加密
                .sign(Algorithm.HMAC256(secret)); // 使用加密密钥对令牌进行签名
        log.info("生成的token为:{}", token);
        return token; // 返回生成的令牌
    }

    /**
     * 校验token并解析token
     *
     * @param token 要校验的token
     * @return 是否校验通过
     */
    public static boolean verifyToken(String token) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build(); // 创建令牌校验器
            jwt = verifier.verify(token); // 校验并解析令牌
            if (jwt.getExpiresAt().before(new Date())) { // 如果令牌已过期
                log.info("token已过期"); // 打印令牌已过期提示
                return false; // 返回校验不通过
            }
        } catch (Exception e) {
            //解码异常则抛出异常
            log.error("token解析异常:{}", e.getMessage()); // 打印令牌解析异常信息
            return false; // 返回校验不通过
        }
        return true; // 返回校验通过
    }

    /**
     *
     * 解析token中的用户名信息
     * @param token 要解析的token
     * @return 解析后的用户名
     */
     public static String getUserName(String token) {
         DecodedJWT jwt = JWT.decode(token); // 解析token
         return jwt.getClaim("userName").asString(); // 获取用户名信息
     }
}