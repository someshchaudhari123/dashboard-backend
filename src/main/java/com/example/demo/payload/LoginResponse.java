package com.example.demo.payload;

public class LoginResponse {
    private String message;
    private String name;
    private String email;

    // getters and setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}