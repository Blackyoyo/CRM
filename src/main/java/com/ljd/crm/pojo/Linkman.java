package main.java.com.ljd.crm.pojo;

public class Linkman {
    private Long lkmId;

    private String lkmName;

    private Long lkmCustId;

    private char lkmGender;

    private String lkmPhone;

    private String lkmMobile;

    private String lkmEmail;

    private String lkmWechat;

    private String lkmPosition;

    private String lkmMemo;

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName == null ? null : lkmName.trim();
    }

    public Long getLkmCustId() {
        return lkmCustId;
    }

    public void setLkmCustId(Long lkmCustId) {
        this.lkmCustId = lkmCustId;
    }

    public char getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(char lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone == null ? null : lkmPhone.trim();
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile == null ? null : lkmMobile.trim();
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail == null ? null : lkmEmail.trim();
    }

    public String getLkmWechat() {
        return lkmWechat;
    }

    public void setLkmWechat(String lkmWechat) {
        this.lkmWechat = lkmWechat == null ? null : lkmWechat.trim();
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition == null ? null : lkmPosition.trim();
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo == null ? null : lkmMemo.trim();
    }
}