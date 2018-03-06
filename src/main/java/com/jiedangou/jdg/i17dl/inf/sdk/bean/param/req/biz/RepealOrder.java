package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.pro.OMessage;

/**
 * Created on 2017/12/10
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class RepealOrder {

    private String orderNum;

    private Integer op;

    private String payPassword;

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    private OMessage om;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public OMessage getOm() {
        return om;
    }

    public void setOm(OMessage om) {
        this.om = om;
    }

    public RepealOrder(String orderNum, Integer op, OMessage om) {
        this.orderNum = orderNum;
        this.op = op;
        this.om = om;
    }

    public RepealOrder(String orderNum, Integer op, String payPassword) {
        this.orderNum = orderNum;
        this.op = op;
        this.payPassword = payPassword;
    }

    public RepealOrder() {
    }
}
