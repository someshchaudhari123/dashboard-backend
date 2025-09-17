package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "settings")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyName;  // e.g., "siteTitle", "themeColor"
    private String value;    // e.g., "My Dashboard", "#4A90E2"

    public Setting() {}

    public Setting(String keyName, String value) {
        this.keyName = keyName;
        this.value = value;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKeyName() { return keyName; }
    public void setKeyName(String keyName) { this.keyName = keyName; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
