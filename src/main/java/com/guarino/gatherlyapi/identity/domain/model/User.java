package com.guarino.gatherlyapi.identity.domain.model;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
public class User {

    private final UUID id;
    private String name;
    private final String email;
    private String passwordHash;
    private final UserRole role;
    private UserStatus status;
    private final ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private User(UUID id,
                 String name,
                 String email,
                 String passwordHash,
                 UserRole role,
                 UserStatus status,
                 ZonedDateTime createdAt,
                 ZonedDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(String name,
                              String email,
                              String passwordHash) {
        var now = ZonedDateTime.now();
        return new User(
                UUID.randomUUID(),
                name,
                email,
                passwordHash,
                UserRole.USER,
                UserStatus.PENDING_VERIFICATION,
                now,
                now
        );
    }

    public static User reconstitute(
            UUID id,
            String name,
            String email,
            String passwordHash,
            UserRole role,
            UserStatus status,
            ZonedDateTime createdAt,
            ZonedDateTime updatedAt) {
        return new User(
                id,
                name,
                email,
                passwordHash,
                role,
                status,
                createdAt,
                updatedAt
        );
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
}