package com.enterProject.enterProject.layered.repository;

import com.enterProject.enterProject.layered.domain.LayeredEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LayeredRepository extends JpaRepository<LayeredEntity, Long> {
}
