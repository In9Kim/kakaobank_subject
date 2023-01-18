package com.example.kakaobank_subject.dto;

public class Credit_Start {
    private String customer_pk; // 고객pk
    private int salary; // 연봉
    private int credit; // 신용등급

    public String getCustomer_pk() {
        return customer_pk;
    }

    public void setCustomer_pk(String customer_pk) {
        this.customer_pk = customer_pk;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Credit_Start{" +
                "Customer_pk='" + customer_pk + '\'' +
                ", salary=" + salary +
                ", credit=" + credit +
                '}';
    }
}
