package com.example.backend.modules.sample.mapper;

import com.example.backend.domain.mapper.BaseMapper;
import com.example.backend.modules.sample.dto.SampleDto;
import com.example.backend.modules.sample.entity.SampleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SampleMapper extends BaseMapper<SampleEntity, SampleDto> {

    @Override
    SampleDto toDto(SampleEntity entity);

    @Override
    SampleEntity toEntity(SampleDto dto);

    @Override
    List<SampleDto> toDtoList(List<SampleEntity> entities);
}
