package com.example.demo.springboot;

public class FruitDto {

	private int id;
	private String fruitname;
	private double fruitprice;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFruitname() {
		return fruitname;
	}
	public void setFruitname(String fruitname) {
		this.fruitname = fruitname;
	}
	public double getFruitprice() {
		return fruitprice;
	}
	public void setFruitprice(double fruitprice) {
		this.fruitprice = fruitprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Fruit toEntity() {
		Fruit entity=new Fruit();
		
		entity.setFruitname(this.fruitname);
		entity.setFruitprice(this.fruitprice);
		entity.setId(this.id);
		entity.setQuantity(this.quantity);
		
		return entity;
	}
}
