package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created on 2017/12/23
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class UncancelOrder {

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public UncancelOrder(String orderNum) {
        this.orderNum = orderNum;
    }

    public UncancelOrder() {
    }
}
