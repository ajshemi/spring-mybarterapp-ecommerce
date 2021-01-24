package com.ajshem.ba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Product{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable=false)
    private String name;

    @ManyToOne
    private Seller seller;

    protected Product(){}

    public Product(String name, Seller seller){
        this.name = name;
        this.seller = seller;
    }

	public Integer getId() {
		return this.id;
	}

    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
    
}