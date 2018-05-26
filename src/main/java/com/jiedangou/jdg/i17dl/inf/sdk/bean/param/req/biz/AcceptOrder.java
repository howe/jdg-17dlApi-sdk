package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created by Jianghao on 2017/12/19
 *
 * @howechiang
 */
public class AcceptOrder {

    /**
     * 服务商订单号
     */
    private String pOrderNo;

    public String getpOrderNo() {
        return pOrderNo;
    }

    public void setpOrderNo(String pOrderNo) {
        this.pOrderNo = pOrderNo;
    }

    /**
     * 合作商订单号
     */
    private String outOrderNo;

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    /**
     * 支付密码
     */
    private String payPassword;

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * 服务商处理员信息
     */
    private String receiver;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public AcceptOrder() {
    }

    public AcceptOrder(String outOrderNo, String pOrderNo, String payPassword, String receiver) {
        this.pOrderNo = pOrderNo;
        this.outOrderNo = outOrderNo;
        this.payPassword = payPassword;
        this.receiver = receiver;
    }
}
