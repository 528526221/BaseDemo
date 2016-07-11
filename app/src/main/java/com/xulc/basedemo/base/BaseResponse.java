package com.xulc.basedemo.base;

/**
 * Created by xuliangchun on 2016/7/11.
 */
public class BaseResponse {
    public int reqseq;
    public int statusCode;

    public int getReqseq() {
        return reqseq;
    }

    public void setReqseq(int reqseq) {
        this.reqseq = reqseq;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
