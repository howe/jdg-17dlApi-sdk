package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created on 2018/2/25
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class UnarbitrationOrder {

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public UnarbitrationOrder(String orderNum) {
        this.orderNum = orderNum;
    }

    public UnarbitrationOrder() {
    }
}
