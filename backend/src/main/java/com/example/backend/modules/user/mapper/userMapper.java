package com.example.backend.modules.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.backend.domain.mapper.BaseMapper;
import com.example.backend.modules.user.dtos.response.UserResponse;
import com.example.backend.modules.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface userMapper extends BaseMapper<UserEntity, UserResponse> {

    @Override
    
    UserResponse toDto(UserEntity entity);

    @Override
    UserEntity toEntity(UserResponse dto);

    @Override
    List<UserResponse> toDtoList(List<UserEntity> entities);

}
