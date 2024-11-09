package com.service.service.core;

import com.service.service.entities.HeartRateDataDTO;
import com.service.service.model.HeartRateData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HeartRateDataMapper {
    HeartRateDataMapper INSTANCE = Mappers.getMapper(HeartRateDataMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "longToInstant")
    HeartRateData toEntity(HeartRateDataDTO heartRateDataDTO);

    @Mapping(target = "recordedAt", source = "recordedAt", qualifiedByName = "instantToLong")
    HeartRateDataDTO toDto(HeartRateData heartRateData);

    List<HeartRateData> toEntityList(List<HeartRateDataDTO> heartRateDataDTOs);
    List<HeartRateDataDTO> toDTOList(List<HeartRateData> heartRateData);

    @Named("longToInstant")
    default Instant longToInstant(long value) {
        return Instant.ofEpochMilli(value);
    }

    @Named("instantToLong")
    default long instantToLong(Instant instant) {
        return instant != null ? instant.toEpochMilli() : 0L;
    }
}
