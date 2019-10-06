package com.ssm.po;

public class Customer {
    private Integer custId;
    private String custName;
    private String custUserName;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustUserName() {
        return custUserName;
    }

    public void setCustUserName(String custUserName) {
        this.custUserName = custUserName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custUserName='" + custUserName + '\'' +
                '}';
    }
}
