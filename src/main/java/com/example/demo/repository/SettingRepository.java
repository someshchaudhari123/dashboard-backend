package com.example.demo.repository;

import com.example.demo.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingRepository extends JpaRepository<Setting, Long> {
    Optional<Setting> findByKeyName(String keyName);
}
