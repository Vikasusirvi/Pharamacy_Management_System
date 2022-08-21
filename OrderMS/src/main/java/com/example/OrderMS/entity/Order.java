package com.example.OrderMS.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderID;
    private Long orderDate;
    private String drugName;
    private int drugQuantity;
    private int drugPrice;
    private Long userID;


}
