package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created by Jianghao on 2017/12/22
 *
 * @howechiang
 */
public class QueryOrderList {

    /**
     * 每页数据量
     */
    private Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 页码
     */
    private Integer pageNumber;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * 游戏ID
     */
    private Integer gameId;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    /**
     * 订单状态
     * 0 已取消
     * 1 已下单（未接手）
     * 2 已接单（未处理）
     * 3 处理中（代练中）
     * 4 待验收
     * 5 撤销中
     * 6 仲裁中
     * 7 异常
     * 8 锁定
     * 9 已下架
     * 10 已撤销
     * 11 已仲裁
     * 12 强制仲裁
     * 13 申述中（服务商申述）
     * 14 已完成
     * 88 已结算
     * 99 已完结
     */
    private Integer orderStatus;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 查询开始时间
     */
    private String queryStartTime;

    public String getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(String queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    /**
     * 查询开始时间
     */
    private String queryEndTime;

    public String getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public QueryOrderList(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public QueryOrderList(Integer pageSize, Integer pageNumber, Integer gameId, Integer orderStatus, String queryStartTime, String queryEndTime) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.gameId = gameId;
        this.orderStatus = orderStatus;
        this.queryStartTime = queryStartTime;
        this.queryEndTime = queryEndTime;
    }

    public QueryOrderList() {
    }
}
