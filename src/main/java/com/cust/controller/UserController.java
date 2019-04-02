package com.cust.controller;

import com.cust.Utils.WxUtils;
import com.cust.service.UserService;
import easy.web.RequestTool;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * @param response,request
     * @return String
     */
    @RequestMapping("/login")
    public String wxUserLogin(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Map map = RequestTool.getParameterMap(request);
        System.out.println(map.get("code"));
        String userOpenId = wxUtils.oauth2GetOpenid((String) map.get("code"));
        System.out.println(userOpenId);
        try {
            //String转为josn
            JSONObject usrOpenIdAndSessionKey = (JSONObject) (new JSONParser().parse(userOpenId));
            if ((int) usrOpenIdAndSessionKey.get("errcode") == 0) {
                //获取openid成功
                String openid = (String) usrOpenIdAndSessionKey.get("openid");
                System.out.println(openid);
                String session_Key = (String) usrOpenIdAndSessionKey.get("session_key");
                System.out.println(session_Key);
                if (userService.selectUserOpenId(openid)) {
                    //此用户为老用户

                } else {
                    //此用户为新用户
                    if (userService.insertUserInfo(map)) {
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
}
