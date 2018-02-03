package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.biz;

import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.resp.BaseResp;

/**
 * Created on 2018/1/29
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class Resp {

    private String status;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Resp() {
    }

    public Resp(BaseResp resp) {
        this.status = resp.getStatus();
        this.message = resp.getMessage();
    }

    public Resp(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
