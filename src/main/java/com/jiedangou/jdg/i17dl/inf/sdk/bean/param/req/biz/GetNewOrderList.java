package com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz;

/**
 * Created on 2017/12/10
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class GetNewOrderList {

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
     * 账号平台
     * 安卓QQ
     * 安卓微信
     * 苹果QQ
     * 苹果微信
     */
    private String channel;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 排序
     * price_desc 价格最高
     * price_asc 价格最低
     * time_desc 时间最长
     * time_asc 时间最短
     */
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 价格区间
     * 1 1-100
     * 2 101-300
     * 3 301-500
     * 4 500以上
     */
    private Integer priceRange;

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * 起始段位
     * 青铜
     * 白银
     * 黄金
     * 铂金
     * 钻石
     * 星耀
     * 王者
     */
    private String startLevel;

    public String getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(String startLevel) {
        this.startLevel = startLevel;
    }

    /**
     * 目标段位
     * 青铜
     * 白银
     * 黄金
     * 铂金
     * 钻石
     * 星耀
     * 王者
     */
    private String endLevel;

    public String getEndLevel() {
        return endLevel;
    }

    public void setEndLevel(String endLevel) {
        this.endLevel = endLevel;
    }

    public GetNewOrderList(Integer pageSize, Integer pageNumber, Integer gameId, String channel, String sort, Integer priceRange, String startLevel, String endLevel) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.gameId = gameId;
        this.channel = channel;
        this.sort = sort;
        this.priceRange = priceRange;
        this.startLevel = startLevel;
        this.endLevel = endLevel;
    }

    public GetNewOrderList(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public GetNewOrderList() {
    }
}
