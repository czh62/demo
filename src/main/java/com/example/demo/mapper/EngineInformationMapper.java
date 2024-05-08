package com.example.demo.mapper;

import com.example.demo.domain.engineInformation.EngineInformationBean;
import com.example.demo.domain.engineInformation.EngineInformationReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EngineInformationMapper {

    List<EngineInformationBean> getList(EngineInformationReq req);

    Integer getCount(EngineInformationReq req);

    Integer insert(EngineInformationReq req);
}
