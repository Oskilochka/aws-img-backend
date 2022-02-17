package com.josk.backend.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class User {

    private UUID userId;
    private String username;
    private String imgUrl;

    public User(UUID userId, String username, String imgUrl) {
        this.username = username;
        this.userId = userId;
        this.imgUrl = imgUrl;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserImageUrl() {
        return Optional.ofNullable(imgUrl);
    }

    public void setUserImageUrl(String userImageUrl) {
        this.imgUrl = userImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, imgUrl);
    }

}
