package com.example.demo.service;

import com.example.demo.domain.engineInformation.EngineInformationDto;
import com.example.demo.domain.engineInformation.EngineInformationReq;
import com.example.demo.domain.response.Response;

import java.util.List;

public interface EngineInformationService {

    Response<List<EngineInformationDto>> getList(EngineInformationReq req);

    Response<Integer> getCount(EngineInformationReq req);

    Response<String> add(EngineInformationReq req);
}
