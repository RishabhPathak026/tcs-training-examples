package com.tcs.streams;

import java.util.List;
import java.util.stream.Collectors;

public class TestStremMethods {

	public static void main(String[] args) {
		List<Dish> dishes = Dish.getAllDishes();
		// list out only the names of the dish in a new list
		List<String> names = dishes.stream()
				.map(dish -> dish.getName()).collect(Collectors.toList());
		names.forEach(name -> System.out.println(name));
		System.out.println("--------------");
		// list out the types of dishes
		List<String> types = dishes.stream()
				.map(dish -> dish.getType()).distinct().collect(Collectors.toList());
		types.forEach(type -> System.out.println(type));
		System.out.println("----- All dishes ----");
		dishes.forEach(dish -> System.out.println(dish));
		System.out.println("------ Producing the dishes with 10% discount -----");
		List<Dish> dishesWithDiscount = dishes.stream().
			map(dish -> new Dish(dish.getName(), dish.getType(), (dish.getPrice() - dish.getPrice() * 0.1)))
			.collect(Collectors.toList());
		dishesWithDiscount.forEach(dish -> System.out.println(dish));
	}

}
