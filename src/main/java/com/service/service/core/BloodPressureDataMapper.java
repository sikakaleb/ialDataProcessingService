package com.service.service.core;

import com.service.service.entities.BloodPressureDataDTO;
import com.service.service.model.BloodPressureData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BloodPressureDataMapper {
    BloodPressureDataMapper INSTANCE = Mappers.getMapper(BloodPressureDataMapper.class);

    BloodPressureData toEntity(BloodPressureDataDTO bloodPressureDataDTO);
    BloodPressureDataDTO toDto(BloodPressureData bloodPressureData);
    List<BloodPressureData> toEntityList(List<BloodPressureDataDTO> bloodPressureDataDTOs);
    List<BloodPressureDataDTO> toDTOList(List<BloodPressureData> bloodPressureData);
}
