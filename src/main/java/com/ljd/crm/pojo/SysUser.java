package main.java.com.ljd.crm.pojo;

public class SysUser {
    private Long userId;

    private String userCode;

    private String userName;

    private String userPassword;

    private char userState;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public char getUserState() {
        return userState;
    }

    public void setUserState(char userState) {
        this.userState = userState;
    }
}