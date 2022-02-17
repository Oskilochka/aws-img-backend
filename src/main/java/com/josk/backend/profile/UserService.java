package com.josk.backend.profile;

import com.josk.backend.datastore.FakeUserDataStore;
import com.josk.backend.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;


@Service
public class UserService {

    private final UserDataAccessService userDataAccessService;


    private FakeUserDataStore fakeUserDataStore;
    private FileStore fileStore;

    @Autowired
    public UserService(UserDataAccessService userDataAccessService) {
        this.userDataAccessService = userDataAccessService;
    }

    List<User> getUsers() {
        return userDataAccessService.getUsers();
    }

    public void uploadImg(UUID userId, MultipartFile file) {

        //1. Check if image is not empty
        if ( file.isEmpty() ) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        //2. Check if file is an image
        if ( !Arrays.asList(ContentType.IMAGE_JPEG, ContentType.IMAGE_PNG, ContentType.IMAGE_GIF ).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image");
        }

        //3. Check if the user is exists in DB
        userDataAccessService
                .getUsers()
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        //4. Grab some metadata from file if any
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //5. Store image into aws and update userProfileImageLink DB with s3 link
        fileStore.save(
                userId,
                file.getName(),
                file.getO
        );

        if ( !file.isEmpty() ) {
            String fileType = file.getContentType();
            Boolean isUserExist = fakeUserDataStore.getUserProfiles().contains(userId);

            String path,
            String fileName,
            Optional<Map<String, String>> optionalMetadata,
            InputStream inputStream

            if ( isUserExist && (fileType == "image/png" || fileType == "image/jpg") ) {
                fileStore.save(
                        userId,
                        file.getName(),
                        file.getO
                );
            }
        }
    }
}
