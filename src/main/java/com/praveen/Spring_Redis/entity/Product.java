package com.praveen.Spring_Redis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.redis.core.RedisHash;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID )
	private UUID productId;
	
	private String productName;
	
	private int productQuantity;
	
	private double productPrice;

}
