package com.cust.Utils;

import org.springframework.stereotype.Component;

@Component
public class WxUtils {
    /**
     * 获取当前微信用户的OpenId(唯一标识当前用户)和session_key(会话密钥)
     */
    public String oauth2GetOpenid(String code) {
        String appid = "wx8371588987507d8e";
        String appsecret = "b184f7322f6d911ed24e4c80de438eac";

        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        return data;
    }

}
