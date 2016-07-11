package com.xulc.basedemo.model;

/**
 * Created by xuliangchun on 2016/7/11.
 */
public class UserLogin {
    private String ttlSeconds;
    private String sessionID;

    public String getTtlSeconds() {
        return ttlSeconds;
    }

    public void setTtlSeconds(String ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
