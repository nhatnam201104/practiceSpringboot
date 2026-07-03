package com.example.backend.modules.sample.entity;

import com.example.backend.domain.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sample")
public class SampleEntity extends BaseEntity {

    @Column(name = "name", nullable = false, length = 255)
    private String name;
}
