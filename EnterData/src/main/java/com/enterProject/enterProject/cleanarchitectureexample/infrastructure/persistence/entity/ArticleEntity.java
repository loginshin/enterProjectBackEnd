package com.enterProject.enterProject.cleanarchitectureexample.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "clean_architecture_articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String content;
}
