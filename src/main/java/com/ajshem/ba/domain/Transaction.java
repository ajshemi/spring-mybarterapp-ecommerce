package com.ajshem.ba.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Buyer buyer;
  

    public Transaction(Product product, Buyer buyer){
        this.product=product;
        this.buyer=buyer;

    }

    protected Transaction(){}


	public Integer getId() {
		return this.id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}


}