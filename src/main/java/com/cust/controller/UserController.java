package com.cust.controller;

import com.cust.Entity.User;
import com.cust.Utils.WxUtils;
import com.cust.service.UserService;
import easy.web.RequestTool;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private WxUtils wxUtils;
    @Autowired
    private UserService userService;

    /**
     * 获取前端code，此方法用于发送请求到auth.code2Session接口获取用户openid以及sessionkey
     * map应包含昵称，国家，城市等微信基本用户信息
     * <p>
     * errcode:
     * -1	系统繁忙，此时请开发者稍候再试
     * 0	请求成功
     * 40029	code 无效
     * 45011	频率限制，每个用户每分钟100次
     *
     * @param request
     * @return
     */
    @RequestMapping("/WeChatlogin")
    public String wxUserLogin(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        Map map = RequestTool.getParameterMap(request);
        if (!map.containsKey("code")) {
            return "-1";
        }
        System.out.println(map.get("code"));
        String userOpenId = wxUtils.oauth2GetOpenid((String) map.get("code"));
        System.out.println(userOpenId);
        try {
            //String转为josn
            JSONObject usrOpenIdAndSessionKey = (JSONObject) (new JSONParser().parse(userOpenId));
            if ((Long) usrOpenIdAndSessionKey.get("errcode") == 0) {
                //获取openid成功
                String openid = (String) usrOpenIdAndSessionKey.get("openid");
                System.out.println(openid);
                String session_Key = (String) usrOpenIdAndSessionKey.get("session_key");
                System.out.println(session_Key);
                if (userService.selectUserOpenId(openid)) {
                    //此用户为老用户

                } else {
                    //此用户为新用户
                    JSONObject wxuser = (JSONObject) (new JSONParser().parse((String) map.get("rawData")));
                    User userInfo = new User();
                    userInfo.setCity(String.valueOf(wxuser.get("city")));
                    userInfo.setCountry(String.valueOf(wxuser.get("country")));
                    userInfo.setGender((Integer) wxuser.get("gender"));
                    userInfo.setNikename(String.valueOf(wxuser.get("nickname")));
                    userInfo.setOpenid(String.valueOf(wxuser.get("openid")));
                    userInfo.setProvince(String.valueOf(wxuser.get("province")));
                    if (userService.insertUserInfo(userInfo)) {
                        //插入新用户成功

                    } else {
                        //插入新用户失败
                        return "-1";
                    }
                }

            } else {
                //获取用户openid失败
                return "-1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "-1";
    }

    /**
     * 获取服务器产生的第三方会话密钥，查询redis进行快速登陆（小程序没有cookie机制）
     *
     * @param request
     * @return
     */
    @RequestMapping("/uuidLogin")
    public Map uuidLogin(HttpServletRequest request) {
        Map map = RequestTool.getParameterMap(request);
        String thirdSessionKey = String.valueOf(map.get("thirdSessionKey"));
        return null;
    }
}
