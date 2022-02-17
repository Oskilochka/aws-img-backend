package com.josk.backend.bucket;

public enum BucketName {
    PROFILE_IMAGE("oskilochka-image-upload");

    private final String bucketName;
    BucketName(String bucketName)  {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
