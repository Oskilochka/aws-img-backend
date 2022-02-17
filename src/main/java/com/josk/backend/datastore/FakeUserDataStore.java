package com.josk.backend.datastore;

import com.josk.backend.profile.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserDataStore {
    private static final List<User> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new User(UUID.randomUUID(), "test", null));
        USER_PROFILES.add(new User(UUID.randomUUID(), "check", null));
    }

    public List<User> getUserProfiles() {
        return USER_PROFILES;
    }
}
