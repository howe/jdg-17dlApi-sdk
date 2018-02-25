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
    private String pOrderNum;

    /**
     * 合作商订单号
     */
    private String outOrderNum;

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

    public String getOutOrderNum() {
        return outOrderNum;
    }

    public void setOutOrderNum(String outOrderNum) {
        this.outOrderNum = outOrderNum;
    }

    public String getpOrderNum() {
        return pOrderNum;
    }

    public void setpOrderNum(String pOrderNum) {
        this.pOrderNum = pOrderNum;
    }

    public AcceptOrder() {
    }

    public AcceptOrder(String outOrderNum, String pOrderNum, String payPassword, String receiver) {
        this.pOrderNum = pOrderNum;
        this.outOrderNum = outOrderNum;
        this.payPassword = payPassword;
        this.receiver = receiver;
    }
}
