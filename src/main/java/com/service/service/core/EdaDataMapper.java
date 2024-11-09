package com.service.service.core;


import com.service.service.entities.EdaDataDTO;
import com.service.service.model.EdaData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EdaDataMapper {
    EdaDataMapper INSTANCE = Mappers.getMapper(EdaDataMapper.class);

    EdaData toEntity(EdaDataDTO edaDataDTO);
    EdaDataDTO toDto(EdaData edaData);
    List<EdaData> toEntityList(List<EdaDataDTO> edaDataDTOs);
    List<EdaDataDTO> toDTOList(List<EdaData> edaData);
}
