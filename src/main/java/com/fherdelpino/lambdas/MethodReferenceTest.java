package com.fherdelpino.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceTest {

	public static void main(String[] args) {
		List<Person> roster = Person.createRoster();
		Person[] rosterArray = roster.toArray(new Person[roster.size()]);

		class PersonAgeComparator implements Comparator<Person> {

			@Override
			public int compare(Person a, Person b) {
				return a.getBirthday().compareTo(b.getBirthday());
			}

		}

		Arrays.sort(rosterArray, new PersonAgeComparator());

		Arrays.sort(rosterArray, new Comparator<Person>() {

			@Override
			public int compare(Person a, Person b) {
				return a.getBirthday().compareTo(b.getBirthday());
			}

		});

//		Arrays.sort(rosterArray,
//				(Person a, Person b) -> {
//					return a.getBirthday().compareTo(b.getBirthday());
//					}
//				);

	}

}
