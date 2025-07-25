package com.guarino.gatherlyapi.domain.model.user;

import java.time.ZonedDateTime;
import java.util.UUID;

public class User {

    private final UUID id;
    private String name;
    private final String email;
    private String passwordHash;
    private final UserRole role;
    private UserStatus status;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public User(UUID id, String email, UserRole role, ZonedDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    public User(UUID id, String name, String email, String passwordHash, UserRole role, UserStatus status, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void updateProfile(String newName) {
        if (newName != null && !newName.isBlank()) {
            this.name = newName;
            this.touch();
        }
    }

    public void changePassword(String newPasswordHash) {
        this.passwordHash = newPasswordHash;
        this.touch();
    }

    public void ban() {
        if (this.status != UserStatus.BANNED) {
            this.status = UserStatus.BANNED;
            this.touch();
        }
    }

    public void activate() {
        if (this.status == UserStatus.PENDING_VERIFICATION) {
            this.status = UserStatus.ACTIVE;
            this.touch();
        }
    }

    public boolean isActive() {
        return this.status == UserStatus.ACTIVE;
    }

    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }

    private void touch() {
        this.updatedAt = ZonedDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }
}
