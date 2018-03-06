package com.jiedangou.jdg.i17dl.inf.sdk.util.inf;

import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.resp.BaseResp;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.dict.Dict;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.biz.PrOrder;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.biz.Resp;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.BaseReq;
import com.jiedangou.jdg.i17dl.inf.sdk.util.HttpUtil;
import com.jiedangou.jdg.i17dl.inf.sdk.util.JdgUtil;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz.*;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;

import java.util.List;


/**
 * Created by Jianghao on 2017/12/7
 *
 * @howechiang
 */
public class OrderUtil {

    /**
     * 4.3 获取新订单列表
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static QueryResult getNewOrderList(Integer providerId, String key, GetNewOrderList biz) {
        try {
            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_GETNEWORDERLIST, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                    List<PrOrder> orders = resp.getData().getAsList("orders", PrOrder.class);
                    Pager pager = resp.getData().getAs("pager", Pager.class);
                    return new QueryResult(orders, pager);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }


    /**
     * 4.4 获取订单信息（接单前）
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static PrOrder getOrder(Integer providerId, String key, GetOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOutOrderNum())) {
                throw new Exception("合作商订单号为空");
            }
            if (Lang.isEmpty(biz.getGameId())) {
                throw new Exception("游戏ID为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_GETORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                    return resp.getData().getAs("order", PrOrder.class);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.5 受理订单
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static PrOrder acceptOrder(Integer providerId, String key, AcceptOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOutOrderNum())) {
                throw new Exception("合作商订单号为空");
            }
            if (Strings.isBlank(biz.getPayPassword())) {
                throw new Exception("支付密码为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            biz.setPayPassword(Lang.md5(biz.getPayPassword()));
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_ACCEPTORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                    return resp.getData().getAs("order", PrOrder.class);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.6 开始订单任务
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp beginOrder(Integer providerId, String key, BeginOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            if (Lang.isEmpty(biz.getOm().getPics())) {
                throw new Exception("上号截图为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_BEGINORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.7 订单异常信息提交
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp abnormalOrder(Integer providerId, String key, AbnormalOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            if (Lang.isEmpty(biz.getOm())) {
                throw new Exception("备注信息");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_ABNORMALORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.8 提交订单验收（完成订单）
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp completeOrder(Integer providerId, String key, CompleteOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            if (Lang.isEmpty(biz.getOm().getPics())) {
                throw new Exception("完成截图为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_COMPLETEORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.9 处理被动订单撤销
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp repealOrder(Integer providerId, String key, RepealOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            if (Lang.isEmpty(biz.getOp())) {
                throw new Exception("执行操作为空");
            }
            if (!Lang.equals(biz.getOp(), 1) && !Lang.equals(biz.getOp(), 0)) {
                throw new Exception("错误的执行操作");
            }
            if (Lang.equals(biz.getOp(), 1) && Strings.isBlank(biz.getPayPassword())) {
                throw new Exception("支付密码为空");
            }
            if (Lang.equals(biz.getOp(), 0) && Lang.isEmpty(biz.getOm())) {
                throw new Exception("备注信息");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            biz.setPayPassword(Lang.md5(biz.getPayPassword()));
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_REPEALORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.10 获取受理的订单列表
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static QueryResult queryOrderList(Integer providerId, String key, QueryOrderList biz) {
        try {
            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_QUERYORDERLIST, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                    List<PrOrder> orders = resp.getData().getAsList("orders", PrOrder.class);
                    Pager pager = resp.getData().getAs("pager", Pager.class);
                    return new QueryResult(orders, pager);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.11 获取订单信息（接单后）
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static PrOrder fetchOrder(Integer providerId, String key, FetchOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_FETCHORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                    return resp.getData().getAs("order", PrOrder.class);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.12 申请订单撤销
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp applycancelOrder(Integer providerId, String key, ApplycancelOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            if (Lang.isEmpty(biz.getRecoup())) {
                throw new Exception("支付赔偿金额");
            }
            if (Lang.isEmpty(biz.getReward())) {
                throw new Exception("需要报酬金额");
            }
            if (Strings.isBlank(biz.getPayPassword())) {
                throw new Exception("支付密码");
            }
            if (Lang.isEmpty(biz.getOm())) {
                throw new Exception("备注信息");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            biz.setPayPassword(Lang.md5(biz.getPayPassword()));
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_APPLYCANCELORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.13 取消订单验收
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp uncompleteOrder(Integer providerId, String key, UncompleteOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_UNCOMPLETEORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }


    /**
     * 4.14 取消订单异常信息
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp unabnormalOrder(Integer providerId, String key, UnabnormalOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            if (Lang.isEmpty(biz.getOm())) {
                throw new Exception("备注信息");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_UNABNORMALORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }


    /**
     * 4.15 取消订单撤销
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp uncancelOrder(Integer providerId, String key, UncancelOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_UNCANCELORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }

    /**
     * 4.16 取消订单仲裁
     *
     * @param providerId
     * @param key
     * @param biz
     * @return
     */
    public static Resp unarbitrationOrder(Integer providerId, String key, UnarbitrationOrder biz) {

        try {

            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            BaseReq req = new BaseReq();
            req.setProviderId(providerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_ORDER_UNARBITRATION, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                return new Resp(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw Lang.wrapThrow(e);
        }
    }
}
