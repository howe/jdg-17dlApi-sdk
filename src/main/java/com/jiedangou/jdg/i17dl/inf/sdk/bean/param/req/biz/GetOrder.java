package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created by Jianghao on 2017/12/22
 *
 * @howechiang
 */
public class GetOrder {

    private String outOrderNo;

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public GetOrder(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public GetOrder() {
    }
}
