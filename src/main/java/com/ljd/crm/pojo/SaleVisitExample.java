package main.java.com.ljd.crm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class SaleVisitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleVisitExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andVisitIdIsNull() {
            addCriterion("visit_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitIdIsNotNull() {
            addCriterion("visit_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitIdEqualTo(Long value) {
            if(value == null || value.toString().length() == 0) {
                return (Criteria) this;
            }
            addCriterion("visit_id =", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdNotEqualTo(Long value) {
            addCriterion("visit_id <>", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdGreaterThan(Long value) {
            addCriterion("visit_id >", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("visit_id >=", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdLessThan(Long value) {
            addCriterion("visit_id <", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdLessThanOrEqualTo(Long value) {
            addCriterion("visit_id <=", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdLike(Long value) {
            addCriterion("visit_id like", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdNotLike(Long value) {
            addCriterion("visit_id not like", value, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdIn(List<Long> values) {
            addCriterion("visit_id in", values, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdNotIn(List<Long> values) {
            addCriterion("visit_id not in", values, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdBetween(Long value1, Long value2) {
            addCriterion("visit_id between", value1, value2, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitIdNotBetween(Long value1, Long value2) {
            addCriterion("visit_id not between", value1, value2, "visitId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdIsNull() {
            addCriterion("visit_cust_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdIsNotNull() {
            addCriterion("visit_cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdEqualTo(Long value) {
            if(value == null || value.toString().length() == 0) {
                return (Criteria) this;
            }
            addCriterion("visit_cust_id =", value, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdNotEqualTo(Long value) {
            addCriterion("visit_cust_id <>", value, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdGreaterThan(Long value) {
            addCriterion("visit_cust_id >", value, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("visit_cust_id >=", value, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdLessThan(Long value) {
            addCriterion("visit_cust_id <", value, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdLessThanOrEqualTo(Long value) {
            addCriterion("visit_cust_id <=", value, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdIn(List<Long> values) {
            addCriterion("visit_cust_id in", values, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdNotIn(List<Long> values) {
            addCriterion("visit_cust_id not in", values, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdBetween(Long value1, Long value2) {
            addCriterion("visit_cust_id between", value1, value2, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitCustIdNotBetween(Long value1, Long value2) {
            addCriterion("visit_cust_id not between", value1, value2, "visitCustId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdIsNull() {
            addCriterion("visit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdIsNotNull() {
            addCriterion("visit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdEqualTo(Long value) {
            if(value == null || value.toString().length() == 0) {
                return (Criteria) this;
            }
            addCriterion("visit_user_id =", value, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdNotEqualTo(Long value) {
            addCriterion("visit_user_id <>", value, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdGreaterThan(Long value) {
            addCriterion("visit_user_id >", value, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("visit_user_id >=", value, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdLessThan(Long value) {
            addCriterion("visit_user_id <", value, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdLessThanOrEqualTo(Long value) {
            addCriterion("visit_user_id <=", value, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdIn(List<Long> values) {
            addCriterion("visit_user_id in", values, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdNotIn(List<Long> values) {
            addCriterion("visit_user_id not in", values, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdBetween(Long value1, Long value2) {
            addCriterion("visit_user_id between", value1, value2, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitUserIdNotBetween(Long value1, Long value2) {
            addCriterion("visit_user_id not between", value1, value2, "visitUserId");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNull() {
            addCriterion("visit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Date value) {
            addCriterionForJDBCDate("visit_time =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("visit_time <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("visit_time >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("visit_time >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Date value) {
            addCriterionForJDBCDate("visit_time <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("visit_time <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(List<Date> values) {
            addCriterionForJDBCDate("visit_time in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("visit_time not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("visit_time between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("visit_time not between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitAddrIsNull() {
            addCriterion("visit_addr is null");
            return (Criteria) this;
        }

        public Criteria andVisitAddrIsNotNull() {
            addCriterion("visit_addr is not null");
            return (Criteria) this;
        }

        public Criteria andVisitAddrEqualTo(String value) {
            addCriterion("visit_addr =", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotEqualTo(String value) {
            addCriterion("visit_addr <>", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrGreaterThan(String value) {
            addCriterion("visit_addr >", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrGreaterThanOrEqualTo(String value) {
            addCriterion("visit_addr >=", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrLessThan(String value) {
            addCriterion("visit_addr <", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrLessThanOrEqualTo(String value) {
            addCriterion("visit_addr <=", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("visit_addr like", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotLike(String value) {
            addCriterion("visit_addr not like", value, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrIn(List<String> values) {
            addCriterion("visit_addr in", values, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotIn(List<String> values) {
            addCriterion("visit_addr not in", values, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrBetween(String value1, String value2) {
            addCriterion("visit_addr between", value1, value2, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitAddrNotBetween(String value1, String value2) {
            addCriterion("visit_addr not between", value1, value2, "visitAddr");
            return (Criteria) this;
        }

        public Criteria andVisitDetailIsNull() {
            addCriterion("visit_detail is null");
            return (Criteria) this;
        }

        public Criteria andVisitDetailIsNotNull() {
            addCriterion("visit_detail is not null");
            return (Criteria) this;
        }

        public Criteria andVisitDetailEqualTo(String value) {
            addCriterion("visit_detail =", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotEqualTo(String value) {
            addCriterion("visit_detail <>", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailGreaterThan(String value) {
            addCriterion("visit_detail >", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailGreaterThanOrEqualTo(String value) {
            addCriterion("visit_detail >=", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailLessThan(String value) {
            addCriterion("visit_detail <", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailLessThanOrEqualTo(String value) {
            addCriterion("visit_detail <=", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailLike(String value) {
            if(value == null || value.length() == 0) {
                return (Criteria) this;
            }
            addCriterion("visit_detail like", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotLike(String value) {
            addCriterion("visit_detail not like", value, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailIn(List<String> values) {
            addCriterion("visit_detail in", values, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotIn(List<String> values) {
            addCriterion("visit_detail not in", values, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailBetween(String value1, String value2) {
            addCriterion("visit_detail between", value1, value2, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitDetailNotBetween(String value1, String value2) {
            addCriterion("visit_detail not between", value1, value2, "visitDetail");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeIsNull() {
            addCriterion("visit_nexttime is null");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeIsNotNull() {
            addCriterion("visit_nexttime is not null");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeEqualTo(Date value) {
            addCriterionForJDBCDate("visit_nexttime =", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("visit_nexttime <>", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("visit_nexttime >", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("visit_nexttime >=", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeLessThan(Date value) {
            addCriterionForJDBCDate("visit_nexttime <", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("visit_nexttime <=", value, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeIn(List<Date> values) {
            addCriterionForJDBCDate("visit_nexttime in", values, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("visit_nexttime not in", values, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("visit_nexttime between", value1, value2, "visitNexttime");
            return (Criteria) this;
        }

        public Criteria andVisitNexttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("visit_nexttime not between", value1, value2, "visitNexttime");
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