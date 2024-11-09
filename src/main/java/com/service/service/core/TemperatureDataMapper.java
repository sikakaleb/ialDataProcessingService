package com.service.service.core;

import com.service.service.entities.TemperatureDataDTO;
import com.service.service.model.TemperatureData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TemperatureDataMapper {
    TemperatureDataMapper INSTANCE = Mappers.getMapper(TemperatureDataMapper.class);

    TemperatureData toEntity(TemperatureDataDTO temperatureDataDTO);
    TemperatureDataDTO toDto(TemperatureData temperatureData);
    List<TemperatureData> toEntityList(List<TemperatureDataDTO> temperatureDataDTOs);
    List<TemperatureDataDTO> toDTOList(List<TemperatureData> temperatureData);
}
