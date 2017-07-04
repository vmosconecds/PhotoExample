package com.codigodelsur.photoexample.data.local.entity;

/**
 * Created by valentin on 6/26/17.
 */

public enum SortPhotoEntity {
    LATEST(0),
    OLDEST(1),
    POPULAR(2);

    private int code;

    SortPhotoEntity(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
