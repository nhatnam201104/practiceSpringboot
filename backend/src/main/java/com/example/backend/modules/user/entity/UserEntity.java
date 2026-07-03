package com.example.backend.modules.user.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.example.backend.domain.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder.Default;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
public class UserEntity extends BaseEntity {

    @Column(nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Default()
    @Column(nullable = false, unique = true)
    private UUID uuid = UUID.randomUUID();

    @Column(nullable = false)
    private LocalDate dob;

    @Default()
    @Column(nullable = false)
    private Roles role = Roles.USER;

}
