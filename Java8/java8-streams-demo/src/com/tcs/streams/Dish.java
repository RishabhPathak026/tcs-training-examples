package com.tcs.streams;

import java.util.ArrayList;
import java.util.List;

public class Dish {
	private String name;
	private String type;
	private double price;
	public Dish(String name, String type, double price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Dish [name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	// temporary list of dishes
	public static List<Dish> getAllDishes() {
		List<Dish> list = new ArrayList<Dish>();
		// veg items
		list.add(new Dish("Fried Rice", "Veg", 150));
		list.add(new Dish("Roti", "Veg", 50));
		list.add(new Dish("Rajma", "Veg", 160));
		list.add(new Dish("Aloo Gobi", "Veg", 180));
		list.add(new Dish("Butter Naan", "Veg", 70));
		list.add(new Dish("Veg Kadai", "Veg", 200));
		// non veg items
		list.add(new Dish("Kalmi Kabab", "Non Veg", 180));
		list.add(new Dish("Kabab", "Non Veg", 120));
		list.add(new Dish("Tandoori Kabab", "Non Veg", 220));
		list.add(new Dish("Grill", "Non Veg", 200));
		list.add(new Dish("Chicken Biryani", "Non Veg", 150));
		list.add(new Dish("Fish", "Non Veg", 380));
		list.add(new Dish("Pepper Chicken", "Non Veg", 140));
		
		return list;
	}
}
