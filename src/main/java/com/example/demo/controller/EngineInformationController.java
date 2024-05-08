package com.example.demo.controller;

import com.example.demo.domain.engineInformation.EngineInformationDto;
import com.example.demo.domain.engineInformation.EngineInformationReq;
import com.example.demo.domain.response.Response;
import com.example.demo.service.EngineInformationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/engineInformationManagement")
public class EngineInformationController {

    @Resource
    EngineInformationService engineInformationService;

    @RequestMapping("/getList")
    @ResponseBody
    public Response<Map<String, Object>> getList(@RequestBody EngineInformationReq req){
        Map<String, Object> result = new HashMap<>();
        Response<List<EngineInformationDto>> listResponse = engineInformationService.getList(req);
        if(listResponse.isSuccess()){
            result.put("list", listResponse.getData());
        }
        Response<Integer> countResponse = engineInformationService.getCount(req);
        if(countResponse.isSuccess()){
            result.put("count", countResponse.getData());
        }

        return Response.success(result);
    }



    @RequestMapping("/add")
    @ResponseBody
    public Response<String> add(@RequestBody EngineInformationReq req) {
        return engineInformationService.add(req);
    }
}
