package com.xulc.basedemo.response;


import com.xulc.basedemo.base.BaseResponse;
import com.xulc.basedemo.model.UserLogin;

/**
 * Created by xuliangchun on 2016/7/11.
 */
public class LoginResponse extends BaseResponse {
    private UserLogin content;

    public UserLogin getContent() {
        return content;
    }

    public void setContent(UserLogin content) {
        this.content = content;
    }
}
