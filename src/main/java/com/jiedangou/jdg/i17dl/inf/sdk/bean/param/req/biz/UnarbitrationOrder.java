package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created on 2018/2/25
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class UnarbitrationOrder {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public UnarbitrationOrder(String orderNo) {
        this.orderNo = orderNo;
    }

    public UnarbitrationOrder() {
    }
}
