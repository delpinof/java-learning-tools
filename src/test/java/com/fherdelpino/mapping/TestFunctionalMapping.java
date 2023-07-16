package com.fherdelpino.mapping;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;



public class TestFunctionalMapping {

	@Test
	public void test() {
		Map<String,Integer> namesMap = new HashMap<>();

		namesMap.computeIfAbsent("Fernando", String::length);
		namesMap.computeIfAbsent("del Pino", String::length);

		System.out.println(namesMap);
	}
}
