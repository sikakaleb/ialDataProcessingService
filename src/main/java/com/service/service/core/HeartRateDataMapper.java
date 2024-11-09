package com.service.service.core;

import com.service.service.entities.HeartRateDataDTO;
import com.service.service.model.HeartRateData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeartRateDataMapper {

    HeartRateData toEntity(HeartRateDataDTO heartRateDataDTO);

    HeartRateDataDTO toDTO(HeartRateData heartRateData);

    List<HeartRateDataDTO> toDTOList(List<HeartRateData> heartRateDataList);
}
