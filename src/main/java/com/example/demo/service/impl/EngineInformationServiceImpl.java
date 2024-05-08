package com.example.demo.service.impl;

import com.example.demo.domain.engineInformation.EngineInformationBean;
import com.example.demo.domain.engineInformation.EngineInformationDto;
import com.example.demo.domain.engineInformation.EngineInformationReq;
import com.example.demo.domain.response.Response;
import com.example.demo.mapStruct.EngineInformationMapStruct;
import com.example.demo.mapper.EngineInformationMapper;
import com.example.demo.service.EngineInformationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineInformationServiceImpl implements EngineInformationService {

    @Resource
    EngineInformationMapper engineInformationMapper;

    @Override
    public Response<List<EngineInformationDto>> getList(EngineInformationReq req) {
        List<EngineInformationBean> beans = engineInformationMapper.getList(req);
        List<EngineInformationDto> dtos = EngineInformationMapStruct.INSTANCE.beans2Dtos(beans);
        return Response.success(dtos);
    }

    @Override
    public Response<Integer> getCount(EngineInformationReq req) {
        Integer count = engineInformationMapper.getCount(req);
        return Response.success(count);
    }

    @Override
    public Response<String> add(EngineInformationReq req) {
        if (engineInformationMapper.insert(req) > 0) {
            return Response.success("添加成功");
        }
        return Response.error("添加失败");
    }
}
