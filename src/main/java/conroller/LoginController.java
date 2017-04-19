package conroller;

import Util.SpringIoC;
import conroller.MsgUnit.LoginInfo;
import conroller.MsgUnit.LoginRes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.Impl.LoginServiceImpl;
import service.LoginService;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/18.
 */
@RestController

public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginRes login(@RequestBody LoginInfo loginInfo, HttpSession httpSession){
        LoginService loginService= SpringIoC.idGetter("loginServiceImpl", LoginServiceImpl.class);
        LoginRes loginRes=new LoginRes();
        String state=loginService.login(loginInfo,httpSession);
        loginRes.setState(state);
        if(state.equals("Success")){
            loginRes.setMsg("Login Success");
        }
        else
            loginRes.setMsg("Login Fail, No such user");
        return loginRes;
    }
}
