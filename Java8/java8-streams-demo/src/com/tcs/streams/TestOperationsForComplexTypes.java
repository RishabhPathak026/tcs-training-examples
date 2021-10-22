package com.tcs.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestOperationsForComplexTypes {

	public static void main(String[] args) {
		List<Dish> dishes = Dish.getAllDishes();
		// Old way of filtering the items with price
		// create a new list to store only non-veg
		List<Dish> nonVegList = new ArrayList<Dish>();
		// iterate the existing list and add only non-veg dish to the new list
		for(Dish dish : dishes) {
			// filter only non veg dish
			if(dish.getType().equals("Non Veg")) {
				nonVegList.add(dish);
			}
		}
		// now only non veg list is available
		printDish(nonVegList);
		// Old way of filtering the non veg items with specific range & sorting it
		List<Dish> priceList = new ArrayList<Dish>();
		for(Dish dish : nonVegList) {
			if(dish.getPrice() >= 150 && dish.getPrice() <= 200) {
				priceList.add(dish);
			}
		}
		System.out.println("Non Veg items");
		printDish(priceList);
		// sorting the priceList in ascending order
		Collections.sort(priceList, new Comparator<Dish>() {
			public int compare(Dish d1, Dish d2) {
				return Double.compare(d1.getPrice(), d2.getPrice());
			}
		});
		System.out.println("Sorted Items");
		printDish(priceList);
	}
	public static void printDish(List<Dish> dishes) {
		for(Dish dish : dishes)
			System.out.println(dish);
		System.out.println("-----------------");
	}

}
