package test.mapping;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class TestFunctionalMapping {

	@Test
	public void test() {
		Map<String,Integer> namesMap = new HashMap<>();

		Integer length = namesMap.computeIfAbsent("Fernando", s -> s.length());
		Integer length2 = namesMap.computeIfAbsent("del Pino", String::length);

		System.out.println(namesMap);
	}
}
