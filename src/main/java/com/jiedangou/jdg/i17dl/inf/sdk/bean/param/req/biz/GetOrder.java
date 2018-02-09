package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created by Jianghao on 2017/12/22
 *
 * @howechiang
 */
public class GetOrder {

    private String outOrderNum;

    public String getOutOrderNum() {
        return outOrderNum;
    }

    public void setOutOrderNum(String outOrderNum) {
        this.outOrderNum = outOrderNum;
    }

    private Integer gameId;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public GetOrder(Integer gameId, String outOrderNum) {
        this.outOrderNum = outOrderNum;
        this.gameId = gameId;
    }

    public GetOrder() {
    }
}
