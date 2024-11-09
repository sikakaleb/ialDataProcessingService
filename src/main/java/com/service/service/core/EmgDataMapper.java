package com.service.service.core;

import com.service.service.entities.EmgDataDTO;
import com.service.service.model.EmgData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmgDataMapper {
    EmgDataMapper INSTANCE = Mappers.getMapper(EmgDataMapper.class);

    EmgData toEntity(EmgDataDTO emgDataDTO);
    EmgDataDTO toDto(EmgData emgData);
    List<EmgData> toEntityList(List<EmgDataDTO> emgDataDTOs);
    List<EmgDataDTO> toDTOList(List<EmgData> emgData);
}
