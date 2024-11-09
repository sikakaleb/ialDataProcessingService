package com.service.service.core;

import com.service.service.entities.BloodPressureDataDTO;
import com.service.service.model.BloodPressureData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface BloodPressureDataMapper {
    BloodPressureDataMapper INSTANCE = Mappers.getMapper(BloodPressureDataMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "longToInstant")
    BloodPressureData toEntity(BloodPressureDataDTO bloodPressureDataDTO);
    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "instantToLong")
    BloodPressureDataDTO toDto(BloodPressureData bloodPressureData);
    List<BloodPressureData> toEntityList(List<BloodPressureDataDTO> bloodPressureDataDTOs);
    List<BloodPressureDataDTO> toDTOList(List<BloodPressureData> bloodPressureData);
}
