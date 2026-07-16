package com.enterProject.enterProject.layeredexample.repository;

import com.enterProject.enterProject.layeredexample.domain.LayeredEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LayeredRepository extends JpaRepository<LayeredEntity, Long> {
}
