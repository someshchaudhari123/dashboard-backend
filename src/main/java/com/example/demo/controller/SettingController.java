package com.example.demo.controller;

import com.example.demo.model.Setting;
import com.example.demo.repository.SettingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "http://localhost:3000")
public class SettingController {

    private final SettingRepository settingRepository;

    public SettingController(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    // Get all settings
    @GetMapping
    public List<Setting> getAllSettings() {
        return settingRepository.findAll();
    }

    // Get setting by keyName
    @GetMapping("/{key}")
    public Setting getSetting(@PathVariable String key) {
        return settingRepository.findByKeyName(key)
                .orElseThrow(() -> new RuntimeException("Setting not found"));
    }

    // Create or update setting
    @PostMapping
    public Setting createOrUpdateSetting(@RequestBody Setting setting) {
        Optional<Setting> existing = settingRepository.findByKeyName(setting.getKeyName());
        if (existing.isPresent()) {
            Setting s = existing.get();
            s.setValue(setting.getValue());
            return settingRepository.save(s);
        }
        return settingRepository.save(setting);
    }
}
