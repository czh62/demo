package com.example.demo.mapStruct;

import com.example.demo.domain.engineInformation.EngineInformationBean;
import com.example.demo.domain.engineInformation.EngineInformationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EngineInformationMapStruct {

    EngineInformationMapStruct INSTANCE = Mappers.getMapper(EngineInformationMapStruct.class);

    EngineInformationDto bean2Dto(EngineInformationBean bean);

    List<EngineInformationDto> beans2Dtos(List<EngineInformationBean> beans);
}
