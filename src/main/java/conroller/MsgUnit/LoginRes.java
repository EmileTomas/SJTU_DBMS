package conroller.MsgUnit;

/**
 * Created by Administrator on 2017/4/18.
 */
public class LoginRes {
    private String state;
    private String msg;

    public LoginRes() {
    }

    public LoginRes(String state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
