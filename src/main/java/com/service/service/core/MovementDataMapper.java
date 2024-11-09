package com.service.service.core;

import com.service.service.entities.MovementDataDTO;
import com.service.service.model.MovementData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementDataMapper {
    MovementDataMapper INSTANCE = Mappers.getMapper(MovementDataMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recordedAt", ignore = true)
    MovementData toEntity(MovementDataDTO movementDataDTO);

    MovementDataDTO toDto(MovementData movementData);

    List<MovementData> toEntityList(List<MovementDataDTO> movementDataDTOs);
    List<MovementDataDTO> toDTOList(List<MovementData> movementData);
}
