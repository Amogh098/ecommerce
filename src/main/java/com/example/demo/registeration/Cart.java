package com.example.demo.registeration;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int c_id;
      @Column
	    private String name;

      @ManyToMany
	    @JoinTable(name = "Cart_Product_Table",
	    joinColumns = {
	    		@JoinColumn(name="cart_id",referencedColumnName = "c_id")
	    },
	    inverseJoinColumns = {
	    		@JoinColumn(name="product_id",referencedColumnName = "p_id")
	    		
	    })
	    private List<Product>items;
      
      @OneToOne
      (mappedBy = "cart")
      private Placeorder order;




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Placeorder getOrder() {
		return order;
	}

	public void setOrder(Placeorder order) {
		this.order = order;
	}

	public Cart(int c_id, String name, List<Product> items, Placeorder order) {
		super();
		this.c_id = c_id;
		this.name = name;
		this.items = items;
		this.order = order;
	}



	


}

