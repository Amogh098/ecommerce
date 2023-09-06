package com.example.demo.registeration;

import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

@Entity
public class Product {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int p_id;
	    @Column
	    private String name;
	    @Column
	    private int price;

	  @ManyToMany(mappedBy = "items")
	  private List<Cart>cart;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public Product(int p_id, String name, int price, List<Cart> cart) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.price = price;
		this.cart = cart;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	  
}
