package com.josk.backend.profile;

import com.josk.backend.datastore.FakeUserDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataAccessService {

    private final FakeUserDataStore fakeUserDataStore;

    @Autowired
    public UserDataAccessService(FakeUserDataStore fakeUserDataStore) {
        this.fakeUserDataStore = fakeUserDataStore;
    }

    List<User> getUsers() {
        return fakeUserDataStore.getUserProfiles();
    }
}
