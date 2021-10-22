package com.tcs.streams;

import java.util.List;
import java.util.stream.Collectors;

public class TestStremOperationsForComplexTypes {

	public static void main(String[] args) {
		List<Dish> dishes = Dish.getAllDishes();
		// applying the filter of stream and add the non veg items in a new list
		List<Dish> nonVegList = dishes.stream().filter(dish -> dish.getType().equals("Non Veg")).collect(Collectors.toList());
		System.out.println("---- Show only non veg dishes -----");
		printDish(nonVegList);
		// applying the filter of stream on non veg list with price in range 150 to 200
		List<Dish> priceList = nonVegList.stream().filter(dish -> dish.getPrice() >= 150 && dish.getPrice() <= 200).collect(Collectors.toList());
		System.out.println("---- Show non veg dishes in range 150 to 200 -----");
		printDish(priceList);
		// sorting the non veg lists with price in ascending order
		List<Dish> sortedList = priceList.stream()
				.sorted((d1, d2) -> Double.compare(d1.getPrice(), d2.getPrice())).collect(Collectors.toList());
		System.out.println("----- Show items in sorted order -------");
		printDish(sortedList);
	}
	public static void printDish(List<Dish> dishes) {
		for(Dish dish : dishes)
			System.out.println(dish);
		System.out.println("-----------------");
	}
}
