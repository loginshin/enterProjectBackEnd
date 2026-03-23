package com.enterProject.enterProject.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @Column(name = "user_key", length = 128, nullable = false)
    private String userKey = UUID.randomUUID().toString();

    @Column(name = "user_id", length = 128, unique = true)
    private String userId;

    @Column(name = "user_name", length = 128)
    private String userName;

    @Column(name = "password", length = 128)
    private String password;

    public UserEntity(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
}
