package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.pro.OMessage;

/**
 * Created on 2017/12/10
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class RepealOrder {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    private String payPassword;

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    private OMessage om;

    private int op;

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public OMessage getOm() {
        return om;
    }

    public void setOm(OMessage om) {
        this.om = om;
    }

    public RepealOrder(String orderNo, int op, String payPassword, OMessage om) {
        this.orderNo = orderNo;
        this.op = op;
        this.payPassword = payPassword;
        this.om = om;
    }

    public RepealOrder() {
    }
}
