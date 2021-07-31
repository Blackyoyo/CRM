package main.java.com.ljd.crm.pojo;

import java.util.Date;

public class SaleVisit {
    private Long visitId;

    private Long visitCustId;

    private Long visitUserId;

    private Date visitTime;

    private String visitAddr;

    private String visitDetail;

    private Date visitNexttime;

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getVisitCustId() {
        return visitCustId;
    }

    public void setVisitCustId(Long visitCustId) {
        this.visitCustId = visitCustId;
    }

    public Long getVisitUserId() {
        return visitUserId;
    }

    public void setVisitUserId(Long visitUserId) {
        this.visitUserId = visitUserId;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitAddr() {
        return visitAddr;
    }

    public void setVisitAddr(String visitAddr) {
        this.visitAddr = visitAddr == null ? null : visitAddr.trim();
    }

    public String getVisitDetail() {
        return visitDetail;
    }

    public void setVisitDetail(String visitDetail) {
        this.visitDetail = visitDetail == null ? null : visitDetail.trim();
    }

    public Date getVisitNexttime() {
        return visitNexttime;
    }

    public void setVisitNexttime(Date visitNexttime) {
        this.visitNexttime = visitNexttime;
    }
}