package com.tcs.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreamForSimpleTypes {
	public static void main(String[] args) {
		// list is the original data structure
		List<Integer> list = new ArrayList<Integer>();
		list.add(30);
		list.add(10);
		list.add(40);
		list.add(20);
		System.out.println("Original List: "+list);
		// applying the stream with forEach
		list.stream().forEach(item -> System.out.println(item));
		System.out.println("----------------------");
		// applying the stream to sort in ascending order 
		list.stream().sorted((x, y) -> Integer.compare(x, y)).forEach(item -> System.out.println(item));
		System.out.println("------original list--------");
		list.stream().forEach(item -> System.out.println(item));
		System.out.println("----------------------");
		// applying the stream to sort in descending order 
		list.stream().sorted((x, y) -> Integer.compare(y, x)).forEach(item -> System.out.println(item));
		System.out.println("------original list--------");
		list.stream().forEach(item -> System.out.println(item));
		// getting a new list that is already sorted in ascending & descending order
		List<Integer> ascList = list.stream().sorted((x, y) -> Integer.compare(x, y)).collect(Collectors.toList());
		System.out.println(ascList);
		List<Integer> descList = list.stream().sorted((x, y) -> Integer.compare(y, x)).collect(Collectors.toList());
		System.out.println(descList);
		System.out.println(list);
	}
}
