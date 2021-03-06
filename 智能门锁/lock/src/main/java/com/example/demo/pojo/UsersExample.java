package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andIphonecallIsNull() {
            addCriterion("iphonecall is null");
            return (Criteria) this;
        }

        public Criteria andIphonecallIsNotNull() {
            addCriterion("iphonecall is not null");
            return (Criteria) this;
        }

        public Criteria andIphonecallEqualTo(String value) {
            addCriterion("iphonecall =", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallNotEqualTo(String value) {
            addCriterion("iphonecall <>", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallGreaterThan(String value) {
            addCriterion("iphonecall >", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallGreaterThanOrEqualTo(String value) {
            addCriterion("iphonecall >=", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallLessThan(String value) {
            addCriterion("iphonecall <", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallLessThanOrEqualTo(String value) {
            addCriterion("iphonecall <=", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallLike(String value) {
            addCriterion("iphonecall like", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallNotLike(String value) {
            addCriterion("iphonecall not like", value, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallIn(List<String> values) {
            addCriterion("iphonecall in", values, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallNotIn(List<String> values) {
            addCriterion("iphonecall not in", values, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallBetween(String value1, String value2) {
            addCriterion("iphonecall between", value1, value2, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andIphonecallNotBetween(String value1, String value2) {
            addCriterion("iphonecall not between", value1, value2, "iphonecall");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNull() {
            addCriterion("lock_id is null");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNotNull() {
            addCriterion("lock_id is not null");
            return (Criteria) this;
        }

        public Criteria andLockIdEqualTo(Integer value) {
            addCriterion("lock_id =", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotEqualTo(Integer value) {
            addCriterion("lock_id <>", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThan(Integer value) {
            addCriterion("lock_id >", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_id >=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThan(Integer value) {
            addCriterion("lock_id <", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThanOrEqualTo(Integer value) {
            addCriterion("lock_id <=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdIn(List<Integer> values) {
            addCriterion("lock_id in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotIn(List<Integer> values) {
            addCriterion("lock_id not in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdBetween(Integer value1, Integer value2) {
            addCriterion("lock_id between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_id not between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andTemppassIsNull() {
            addCriterion("temppass is null");
            return (Criteria) this;
        }

        public Criteria andTemppassIsNotNull() {
            addCriterion("temppass is not null");
            return (Criteria) this;
        }

        public Criteria andTemppassEqualTo(Integer value) {
            addCriterion("temppass =", value, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassNotEqualTo(Integer value) {
            addCriterion("temppass <>", value, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassGreaterThan(Integer value) {
            addCriterion("temppass >", value, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassGreaterThanOrEqualTo(Integer value) {
            addCriterion("temppass >=", value, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassLessThan(Integer value) {
            addCriterion("temppass <", value, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassLessThanOrEqualTo(Integer value) {
            addCriterion("temppass <=", value, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassIn(List<Integer> values) {
            addCriterion("temppass in", values, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassNotIn(List<Integer> values) {
            addCriterion("temppass not in", values, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassBetween(Integer value1, Integer value2) {
            addCriterion("temppass between", value1, value2, "temppass");
            return (Criteria) this;
        }

        public Criteria andTemppassNotBetween(Integer value1, Integer value2) {
            addCriterion("temppass not between", value1, value2, "temppass");
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