package com.service.service.core;

import com.service.service.entities.RespiratoryRateDataDTO;
import com.service.service.model.RespiratoryRateData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface RespiratoryRateDataMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "longToInstant")
    RespiratoryRateData toEntity(RespiratoryRateDataDTO respiratoryRateDataDTO);

    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "instantToLong")
    RespiratoryRateDataDTO toDto(RespiratoryRateData respiratoryRateData);

    List<RespiratoryRateData> toEntityList(List<RespiratoryRateDataDTO> respiratoryRateDataDTOs);
    List<RespiratoryRateDataDTO> toDTOList(List<RespiratoryRateData> respiratoryRateData);
}
