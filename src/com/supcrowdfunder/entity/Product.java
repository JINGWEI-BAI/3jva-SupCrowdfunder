package com.supcrowdfunder.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	private String name;
	
	private String content;
    
	private Float completion;
	
	private String creator;
	
	private Date date;
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@ManyToOne
    @JoinColumn(name = "category_fk")
    private Category category;
	
	@ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;
     
    public Product(){}
    
    public Product(String name, String content, Float completion, String creator,Date date,Category category,User user){
    	this.name = name;
    	this.content = content;
    	this.completion = completion;
    	this.category = category;
    	
    	this.date = date;
    	this.creator = creator;
    	this.user = user;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Float getCompletion() {
		return completion;
	}
	public void setCompletion(Float completion) {
		this.completion = completion;
	}

	public Category getCategory() {
		return category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}

