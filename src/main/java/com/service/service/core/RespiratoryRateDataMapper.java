package com.service.service.core;

import com.service.service.entities.RespiratoryRateDataDTO;
import com.service.service.model.RespiratoryRateData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RespiratoryRateDataMapper {
    RespiratoryRateDataMapper INSTANCE = Mappers.getMapper(RespiratoryRateDataMapper.class);

    RespiratoryRateData toEntity(RespiratoryRateDataDTO respiratoryRateDataDTO);
    RespiratoryRateDataDTO toDto(RespiratoryRateData respiratoryRateData);
    List<RespiratoryRateData> toEntityList(List<RespiratoryRateDataDTO> respiratoryRateDataDTOs);
    List<RespiratoryRateDataDTO> toDTOList(List<RespiratoryRateData> respiratoryRateData);
}
