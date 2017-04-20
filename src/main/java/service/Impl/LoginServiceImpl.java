package service.Impl;

import DAO.UserDao;
import DB_model.User;
import conroller.MsgUnit.LoginInfo;
import service.LoginService;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/19.
 */
public class LoginServiceImpl implements LoginService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String login(LoginInfo loginInfo, HttpSession session){
        User user=userDao.find(loginInfo.getAccount());
        if(user!=null){
            session.setAttribute("account",user.getAccount());
            session.setAttribute("type",user.getUserType());
            session.setAttribute("stuID",user.getStuID());
            return "Success";
        }
        return "Fail";
    }
}
