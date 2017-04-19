package service;

import conroller.MsgUnit.LoginInfo;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/19.
 */

public interface LoginService {
    public String login(LoginInfo loginInfo, HttpSession session);


}
