package com.fherdelpino.lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {

	public static void main(String... args) {
		List<Person> roster = Person.createRoster();

		// With an implemented class
		printPersons(roster, new CheckPersonEligibleForSelectiveService());

		// With anonymous class
		printPersons(roster, new CheckPerson() {

			@Override
			public boolean test(Person p) {
				return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}

		});

		// With lambda
		printPersons(roster, (Person p) -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		// With lambda and Predicate<T>
		printPersonsWithPredicate(roster, p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		// With lambda and generic interfaces
		processPersons(roster,
					p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
					p -> p.printPerson()
				);

		processPersonsWithFunction(roster,
				p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(),
				s -> System.out.println(s));

		// With all generics interfaces
		processElements(roster,
				p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(),
				s -> System.out.println(s));

		//Aggregate operations that accept lambda expressions
		roster.stream()
				.filter(p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
				.map(p -> p.getEmailAddress())
				.forEach(email -> System.out.println(email));

	}

	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster)
			if (p.getAge() >= age)
				p.printPerson();
	}

	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster)
			if (p.getAge() >= low && p.getAge() < high)
				p.printPerson();

	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster)
			if (tester.test(p))
				p.printPerson();
	}

	// using functional interfaces Predicate<T>
	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster)
			if (tester.test(p))
				p.printPerson();
	}

	// using functional interfaces Predicate<T> and Consumer<T>
	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block ) {
		for (Person p: roster)
			if(tester.test(p))
				block.accept(p);
	}

	// using functional interfaces Predicate<T>, Consumer<T> and Function<T,R>
	public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
		for(Person p: roster)
			if(tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
	}

	// Completely Generics!
	public static <X,Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X,Y> mapper, Consumer<Y> block) {
		for(X x: source) {
			if(tester.test(x)) {
				Y y = mapper.apply(x);
				block.accept(y);
			}
		}
	}


}
