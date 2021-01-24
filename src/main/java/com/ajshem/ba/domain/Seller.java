package com.ajshem.ba.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable=false)
    private String name;


    protected Seller(){}

    public Seller(String name){
      this.name = name;
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

}