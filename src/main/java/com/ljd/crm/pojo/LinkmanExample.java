package main.java.com.ljd.crm.pojo;

import java.util.ArrayList;
import java.util.List;


public class LinkmanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LinkmanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLkmIdIsNull() {
            addCriterion("lkm_id is null");
            return (Criteria) this;
        }

        public Criteria andLkmIdIsNotNull() {
            addCriterion("lkm_id is not null");
            return (Criteria) this;
        }

        public Criteria andLkmIdEqualTo(Long value) {
            if(value == null || value.toString().length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_id =", value, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdNotEqualTo(Long value) {
            addCriterion("lkm_id <>", value, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdGreaterThan(Long value) {
            addCriterion("lkm_id >", value, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lkm_id >=", value, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdLessThan(Long value) {
            addCriterion("lkm_id <", value, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdLessThanOrEqualTo(Long value) {
            addCriterion("lkm_id <=", value, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdIn(List<Long> values) {
            addCriterion("lkm_id in", values, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdNotIn(List<Long> values) {
            addCriterion("lkm_id not in", values, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdBetween(Long value1, Long value2) {
            addCriterion("lkm_id between", value1, value2, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmIdNotBetween(Long value1, Long value2) {
            addCriterion("lkm_id not between", value1, value2, "lkmId");
            return (Criteria) this;
        }

        public Criteria andLkmNameIsNull() {
            addCriterion("lkm_name is null");
            return (Criteria) this;
        }

        public Criteria andLkmNameIsNotNull() {
            addCriterion("lkm_name is not null");
            return (Criteria) this;
        }

        public Criteria andLkmNameEqualTo(String value) {
            addCriterion("lkm_name =", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameNotEqualTo(String value) {
            addCriterion("lkm_name <>", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameGreaterThan(String value) {
            addCriterion("lkm_name >", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_name >=", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameLessThan(String value) {
            addCriterion("lkm_name <", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameLessThanOrEqualTo(String value) {
            addCriterion("lkm_name <=", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_name like", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameNotLike(String value) {
            addCriterion("lkm_name not like", value, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameIn(List<String> values) {
            addCriterion("lkm_name in", values, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameNotIn(List<String> values) {
            addCriterion("lkm_name not in", values, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameBetween(String value1, String value2) {
            addCriterion("lkm_name between", value1, value2, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmNameNotBetween(String value1, String value2) {
            addCriterion("lkm_name not between", value1, value2, "lkmName");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdIsNull() {
            addCriterion("lkm_cust_id is null");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdIsNotNull() {
            addCriterion("lkm_cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdEqualTo(Long value) {
            if(value == null || value.toString().length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_cust_id =", value, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdNotEqualTo(Long value) {
            addCriterion("lkm_cust_id <>", value, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdGreaterThan(Long value) {
            addCriterion("lkm_cust_id >", value, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lkm_cust_id >=", value, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdLessThan(Long value) {
            addCriterion("lkm_cust_id <", value, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdLessThanOrEqualTo(Long value) {
            addCriterion("lkm_cust_id <=", value, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdIn(List<Long> values) {
            addCriterion("lkm_cust_id in", values, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdNotIn(List<Long> values) {
            addCriterion("lkm_cust_id not in", values, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdBetween(Long value1, Long value2) {
            addCriterion("lkm_cust_id between", value1, value2, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmCustIdNotBetween(Long value1, Long value2) {
            addCriterion("lkm_cust_id not between", value1, value2, "lkmCustId");
            return (Criteria) this;
        }

        public Criteria andLkmGenderIsNull() {
            addCriterion("lkm_gender is null");
            return (Criteria) this;
        }

        public Criteria andLkmGenderIsNotNull() {
            addCriterion("lkm_gender is not null");
            return (Criteria) this;
        }

        public Criteria andLkmGenderEqualTo(String value) {
            if(value.length() == 1) {
                return (Criteria) this;
            }
            addCriterion("lkm_gender =", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderNotEqualTo(String value) {
            addCriterion("lkm_gender <>", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderGreaterThan(String value) {
            addCriterion("lkm_gender >", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_gender >=", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderLessThan(String value) {
            addCriterion("lkm_gender <", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderLessThanOrEqualTo(String value) {
            addCriterion("lkm_gender <=", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_gender like", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderNotLike(String value) {
            addCriterion("lkm_gender not like", value, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderIn(List<String> values) {
            addCriterion("lkm_gender in", values, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderNotIn(List<String> values) {
            addCriterion("lkm_gender not in", values, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderBetween(String value1, String value2) {
            addCriterion("lkm_gender between", value1, value2, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmGenderNotBetween(String value1, String value2) {
            addCriterion("lkm_gender not between", value1, value2, "lkmGender");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneIsNull() {
            addCriterion("lkm_phone is null");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneIsNotNull() {
            addCriterion("lkm_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneEqualTo(String value) {
            addCriterion("lkm_phone =", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneNotEqualTo(String value) {
            addCriterion("lkm_phone <>", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneGreaterThan(String value) {
            addCriterion("lkm_phone >", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_phone >=", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneLessThan(String value) {
            addCriterion("lkm_phone <", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneLessThanOrEqualTo(String value) {
            addCriterion("lkm_phone <=", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_phone like", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneNotLike(String value) {
            addCriterion("lkm_phone not like", value, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneIn(List<String> values) {
            addCriterion("lkm_phone in", values, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneNotIn(List<String> values) {
            addCriterion("lkm_phone not in", values, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneBetween(String value1, String value2) {
            addCriterion("lkm_phone between", value1, value2, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmPhoneNotBetween(String value1, String value2) {
            addCriterion("lkm_phone not between", value1, value2, "lkmPhone");
            return (Criteria) this;
        }

        public Criteria andLkmMobileIsNull() {
            addCriterion("lkm_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLkmMobileIsNotNull() {
            addCriterion("lkm_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLkmMobileEqualTo(String value) {
            addCriterion("lkm_mobile =", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileNotEqualTo(String value) {
            addCriterion("lkm_mobile <>", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileGreaterThan(String value) {
            addCriterion("lkm_mobile >", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_mobile >=", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileLessThan(String value) {
            addCriterion("lkm_mobile <", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileLessThanOrEqualTo(String value) {
            addCriterion("lkm_mobile <=", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_mobile like", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileNotLike(String value) {
            addCriterion("lkm_mobile not like", value, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileIn(List<String> values) {
            addCriterion("lkm_mobile in", values, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileNotIn(List<String> values) {
            addCriterion("lkm_mobile not in", values, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileBetween(String value1, String value2) {
            addCriterion("lkm_mobile between", value1, value2, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmMobileNotBetween(String value1, String value2) {
            addCriterion("lkm_mobile not between", value1, value2, "lkmMobile");
            return (Criteria) this;
        }

        public Criteria andLkmEmailIsNull() {
            addCriterion("lkm_email is null");
            return (Criteria) this;
        }

        public Criteria andLkmEmailIsNotNull() {
            addCriterion("lkm_email is not null");
            return (Criteria) this;
        }

        public Criteria andLkmEmailEqualTo(String value) {
            addCriterion("lkm_email =", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailNotEqualTo(String value) {
            addCriterion("lkm_email <>", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailGreaterThan(String value) {
            addCriterion("lkm_email >", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_email >=", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailLessThan(String value) {
            addCriterion("lkm_email <", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailLessThanOrEqualTo(String value) {
            addCriterion("lkm_email <=", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_email like", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailNotLike(String value) {
            addCriterion("lkm_email not like", value, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailIn(List<String> values) {
            addCriterion("lkm_email in", values, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailNotIn(List<String> values) {
            addCriterion("lkm_email not in", values, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailBetween(String value1, String value2) {
            addCriterion("lkm_email between", value1, value2, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmEmailNotBetween(String value1, String value2) {
            addCriterion("lkm_email not between", value1, value2, "lkmEmail");
            return (Criteria) this;
        }

        public Criteria andLkmWechatIsNull() {
            addCriterion("lkm_wechat is null");
            return (Criteria) this;
        }

        public Criteria andLkmWechatIsNotNull() {
            addCriterion("lkm_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andLkmWechatEqualTo(String value) {
            addCriterion("lkm_wechat =", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatNotEqualTo(String value) {
            addCriterion("lkm_wechat <>", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatGreaterThan(String value) {
            addCriterion("lkm_wechat >", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_wechat >=", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatLessThan(String value) {
            addCriterion("lkm_wechat <", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatLessThanOrEqualTo(String value) {
            addCriterion("lkm_wechat <=", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_wechat like", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatNotLike(String value) {
            addCriterion("lkm_wechat not like", value, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatIn(List<String> values) {
            addCriterion("lkm_wechat in", values, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatNotIn(List<String> values) {
            addCriterion("lkm_wechat not in", values, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatBetween(String value1, String value2) {
            addCriterion("lkm_wechat between", value1, value2, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmWechatNotBetween(String value1, String value2) {
            addCriterion("lkm_wechat not between", value1, value2, "lkmWechat");
            return (Criteria) this;
        }

        public Criteria andLkmPositionIsNull() {
            addCriterion("lkm_position is null");
            return (Criteria) this;
        }

        public Criteria andLkmPositionIsNotNull() {
            addCriterion("lkm_position is not null");
            return (Criteria) this;
        }

        public Criteria andLkmPositionEqualTo(String value) {
            addCriterion("lkm_position =", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionNotEqualTo(String value) {
            addCriterion("lkm_position <>", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionGreaterThan(String value) {
            addCriterion("lkm_position >", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_position >=", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionLessThan(String value) {
            addCriterion("lkm_position <", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionLessThanOrEqualTo(String value) {
            addCriterion("lkm_position <=", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_position like", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionNotLike(String value) {
            addCriterion("lkm_position not like", value, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionIn(List<String> values) {
            addCriterion("lkm_position in", values, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionNotIn(List<String> values) {
            addCriterion("lkm_position not in", values, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionBetween(String value1, String value2) {
            addCriterion("lkm_position between", value1, value2, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmPositionNotBetween(String value1, String value2) {
            addCriterion("lkm_position not between", value1, value2, "lkmPosition");
            return (Criteria) this;
        }

        public Criteria andLkmMemoIsNull() {
            addCriterion("lkm_memo is null");
            return (Criteria) this;
        }

        public Criteria andLkmMemoIsNotNull() {
            addCriterion("lkm_memo is not null");
            return (Criteria) this;
        }

        public Criteria andLkmMemoEqualTo(String value) {
            addCriterion("lkm_memo =", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoNotEqualTo(String value) {
            addCriterion("lkm_memo <>", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoGreaterThan(String value) {
            addCriterion("lkm_memo >", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoGreaterThanOrEqualTo(String value) {
            addCriterion("lkm_memo >=", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoLessThan(String value) {
            addCriterion("lkm_memo <", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoLessThanOrEqualTo(String value) {
            addCriterion("lkm_memo <=", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("lkm_memo like", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoNotLike(String value) {
            addCriterion("lkm_memo not like", value, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoIn(List<String> values) {
            addCriterion("lkm_memo in", values, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoNotIn(List<String> values) {
            addCriterion("lkm_memo not in", values, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoBetween(String value1, String value2) {
            addCriterion("lkm_memo between", value1, value2, "lkmMemo");
            return (Criteria) this;
        }

        public Criteria andLkmMemoNotBetween(String value1, String value2) {
            addCriterion("lkm_memo not between", value1, value2, "lkmMemo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}