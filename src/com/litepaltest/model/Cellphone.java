package com.litepaltest.model;

import org.litepal.crud.DataSupport;

public class Cellphone extends DataSupport {

	private long id;

	private String brand;

	private char inStock;

	private double price;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the inStock
	 */
	public char getInStock() {
		return inStock;
	}

	/**
	 * @param inStock
	 *            the inStock to set
	 */
	public void setInStock(char inStock) {
		this.inStock = inStock;
	}

}
