package com.gen.select.radioapp.stations.domain.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by mohamed on 11/02/2017.
 */

public class Station {

    private Long mId;
    private String mName;
    private String mDescription;
    private String mType;
    private String mStream;
    private String mNPUrl;
    private int mThumbnail;

    public Station(@Nullable String name, @Nullable String description,
                   @NonNull Long id, @NonNull int thumbnail) {
        mId = id;
        mName = name;
        mDescription = description;
        mThumbnail = thumbnail;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getStream() {
        return mStream;
    }

    public void setStream(String mStream) {
        this.mStream = mStream;
    }

    public String getNPUrl() {
        return mNPUrl;
    }

    public void setNPUrl(String mNPUrl) {
        this.mNPUrl = mNPUrl;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}
