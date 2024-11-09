package com.service.service.core;

import com.service.service.entities.EcgDataDTO;
import com.service.service.model.EcgData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EcgDataMapper {
    EcgDataMapper INSTANCE = Mappers.getMapper(EcgDataMapper.class);

    EcgData toEntity(EcgDataDTO ecgDataDTO);
    EcgDataDTO toDto(EcgData ecgData);
    List<EcgData> toEntityList(List<EcgDataDTO> ecgDataDTOs);

    List<EcgDataDTO> toDTOList(List<EcgData> ecgData);
}
