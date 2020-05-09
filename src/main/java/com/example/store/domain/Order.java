package com.example.store.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToMany
	private List<Goods> listOfGoods;
	
	private long priceSummary;
	
	private float discountFromOrder;
	
	private float discountSummary;
	
	private Date dateAt;
	
	private Date deliveryDate;
	
	@OneToOne
	private DeliveryStatus status;
	
}