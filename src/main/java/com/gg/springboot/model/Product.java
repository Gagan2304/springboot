package com.gg.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Products")
public class Product {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "p_name")
	private String pName;
	
	@Column(name = "p_Catagory")
	private String pCatagory;
	
	@Column(name = "p_Price")
	private double pPrice;
	
	public Product() {
		
	}
		
	public Product(String pName, String pCatagory, double pPrice) {
		super();
		this.pName = pName;
		this.pCatagory = pCatagory;
		this.pPrice = pPrice;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCatagory() {
		return pCatagory;
	}
	public void setpCatagory(String pCatagory) {
		this.pCatagory = pCatagory;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	
	

}
