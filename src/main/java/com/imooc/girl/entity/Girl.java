package com.imooc.girl.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
//告诉hibernate此类为实体类
public class Girl {

    @Id //定义此属性对应为数据库中该表的id
    @GeneratedValue //设置id为自动增长的
    private Integer id;

    @NotBlank(message = "总要有点")
    private String cupSize;


    @NotNull(message = "死人不行")
    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    @NotNull(message = "必须输入金额")
    private Double money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
