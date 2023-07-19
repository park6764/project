package com.korea.k2.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrderOneVO {
 private int     baesongbi;
 private int 	 totalmoney;
 private Date	 getdate;
 private String  custname;
 private String  phone; 
 private String  address; 
 private int     orderg; 
 private int     idx;
 private String  productname ; 
 private int     productid ; 
 private int     amount;
}
