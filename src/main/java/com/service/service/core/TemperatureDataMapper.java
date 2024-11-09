package com.service.service.core;

import com.service.service.entities.TemperatureDataDTO;
import com.service.service.model.TemperatureData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface TemperatureDataMapper {
    TemperatureDataMapper INSTANCE = Mappers.getMapper(TemperatureDataMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "longToInstant")
    TemperatureData toEntity(TemperatureDataDTO temperatureDataDTO);

    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "instantToLong")
    TemperatureDataDTO toDto(TemperatureData temperatureData);

    List<TemperatureData> toEntityList(List<TemperatureDataDTO> temperatureDataDTOs);
    List<TemperatureDataDTO> toDTOList(List<TemperatureData> temperatureData);
}
