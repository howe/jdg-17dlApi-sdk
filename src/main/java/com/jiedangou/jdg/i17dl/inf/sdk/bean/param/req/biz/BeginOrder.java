package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.pro.OMessage;

/**
 * Created on 2017/12/23
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class BeginOrder {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    private OMessage om;

    public OMessage getOm() {
        return om;
    }

    public void setOm(OMessage om) {
        this.om = om;
    }

    public BeginOrder(String orderNo, OMessage om) {
        this.orderNo = orderNo;
        this.om = om;
    }

    public BeginOrder() {
    }
}
