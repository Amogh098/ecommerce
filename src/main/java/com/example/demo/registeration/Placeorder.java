package com.example.demo.registeration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Placeorder {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int o_id;
   
	
    @Column
    private int Total_price;
   
    @OneToOne
    @JoinColumn
    private Cart cart;
    
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getTotal_price() {
		return Total_price;
	}
	public void setTotal_price(int total_price) {
		Total_price = total_price;
	}

	
	public Placeorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Placeorder(int o_id, int total_price, Cart cart) {
		super();
		this.o_id = o_id;
		Total_price = total_price;
		this.cart = cart;
	}
	
    
}
