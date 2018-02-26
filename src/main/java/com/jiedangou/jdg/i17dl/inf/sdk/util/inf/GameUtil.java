package com.jiedangou.jdg.i17dl.inf.sdk.util.inf;

import com.jiedangou.jdg.i17dl.inf.sdk.bean.dict.Dict;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.biz.QueryGame;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.resp.BaseResp;
import com.jiedangou.jdg.i17dl.inf.sdk.util.JdgUtil;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.biz.Game;
import com.jiedangou.jdg.i17dl.inf.sdk.bean.param.req.BaseReq;
import com.jiedangou.jdg.i17dl.inf.sdk.util.HttpUtil;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;

import java.util.List;

/**
 * Created on 2017/11/25
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class GameUtil {

    /**
     * 4.1 获取游戏列表
     *
     * @param providerId 服务商ID
     * @param key        密钥key
     * @return
     */
    public static List<Game> queryGameList(Integer providerId, String key) {

        try {
            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            } else if (Strings.isBlank(key)) {
                throw new Exception("key为空");
            } else {
                BaseReq req = new BaseReq();
                req.setProviderId(providerId);
                req.setTimestamp(Times.getTS());
                req.setVersion(Dict.JDG_API_VERSION);
                req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
                String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_GAME_QUERYGAMELIST, Json.toJson(req));
                if (Strings.isEmpty(json)) {
                    throw new Exception("返回值异常");
                } else {
                    BaseResp resp = Json.fromJson(BaseResp.class, json);
                    if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                        return resp.getData().getAsList("games", Game.class);
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 4.2 获取游戏区服详情
     *
     * @param providerId 服务商ID
     * @param key        密钥key
     * @return
     */
    public static Game queryGame(Integer providerId, String key, QueryGame biz) {

        try {
            if (Lang.isEmpty(providerId)) {
                throw new Exception("服务商ID为空");
            } else if (Strings.isBlank(key)) {
                throw new Exception("key为空");
            } else if (Lang.isEmpty(biz.getGameId())) {
                throw new Exception("gameId为空");
            } else {
                BaseReq req = new BaseReq();
                req.setProviderId(providerId);
                req.setTimestamp(Times.getTS());
                req.setVersion(Dict.JDG_API_VERSION);
                req.setBizData(Lang.obj2nutmap(biz));
                req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
                String json = HttpUtil.post(Dict.JDG_API_DEV_HOST + Dict.JDG_API_ACTION_GAME_QUERYGAMEDETAIL, Json.toJson(req));
                if (Strings.isEmpty(json)) {
                    throw new Exception("返回值异常");
                } else {
                    BaseResp resp = Json.fromJson(BaseResp.class, json);
                    if (Strings.equalsIgnoreCase(resp.getStatus(), Dict.RTN_SUCCESS)) {
                        return resp.getData().getAs("game", Game.class);
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
