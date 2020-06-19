package com.fherdelpino.mapping;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapTest {

	public static void main(String[] args) {
		Map<String,Integer> namesMap = new HashMap<>();

		Integer length = namesMap.computeIfAbsent("Fernando", s -> s.length());
		Integer length2 = namesMap.computeIfAbsent("del Pino", String::length);

		System.out.println(namesMap);

		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'" + s + "'";

		Function<Integer, String> quoteIntToString = quote.compose(intToString);

//		assertEquals("'5'", quoteIntToString.apply(5));

	}

}
