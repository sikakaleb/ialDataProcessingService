package com.service.service.core;

import com.service.service.entities.SpO2DataDTO;
import com.service.service.model.SpO2Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpO2DataMapper {
    SpO2DataMapper INSTANCE = Mappers.getMapper(SpO2DataMapper.class);

    SpO2Data toEntity(SpO2DataDTO spO2DataDTO);
    SpO2DataDTO toDto(SpO2Data spO2Data);
    List<SpO2Data> toEntityList(List<SpO2DataDTO> spO2DataDTOs);
    List<SpO2DataDTO> toDTOList(List<SpO2Data> spO2Data);
}
