package com.example.backend.modules.user.entity;

import com.example.backend.domain.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class UserAvance extends BaseEntity {
    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = true, length = 255)
    private String avatar;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserEntity.class)
    private UserEntity user;
}
