package com.enterProject.enterProject.layeredexample.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "layered_examples")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LayeredEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String value;

    public static LayeredEntity create(String value) {
        validate(value);
        return new LayeredEntity(null, value.trim());
    }

    public void update(String value) {
        validate(value);
        this.value = value.trim();
    }

    private static void validate(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("LAYERED_VALUE_REQUIRED");
        if (value.trim().length() > 100) throw new IllegalArgumentException("LAYERED_VALUE_TOO_LONG");
    }
}
