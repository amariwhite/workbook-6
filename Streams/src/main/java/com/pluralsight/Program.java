package com.pluralsight;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = Arrays.asList(
                new Person("Liam", "Johnson", 25),
                new Person("Emma", "Williams", 32),
                new Person("Noah", "Brown", 41),
                new Person("Olivia", "Jones", 19),
                new Person("Elijah", "Garcia", 28),
                new Person("Ava", "Martinez", 37),
                new Person("Lucas", "Davis", 30),
                new Person("Sophia", "Rodriguez", 22),
                new Person("Mason", "Miller", 44),
                new Person("Isabella", "Hernandez", 26)
        );

        System.out.print("Enter a first or last name to search: ");
        String nameToSearch = scanner.nextLine().trim();

        List<Person> matches = new ArrayList<>();
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(nameToSearch) ||
                    person.getLastName().equalsIgnoreCase(nameToSearch)) {
                matches.add(person);
            }
        }
        //stream to filter matching names
        List<Person> person = people.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(nameToSearch) ||
                        p.getLastName().equalsIgnoreCase(nameToSearch))
                .collect(Collectors.toList());

        System.out.println("\nPeople with matching name:");
        matches.forEach(p -> System.out.println(p.getFullName()));

        // Step 3: Calculate average, max, min age using streams
        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();

        OptionalInt oldest = people.stream()
                .mapToInt(Person::getAge)
                .max();

        OptionalInt youngest = people.stream()
                .mapToInt(Person::getAge)
                .min();

        System.out.printf("\nAverage Age: %.2f\n", averageAge.orElse(0));
        System.out.println("Oldest Age: " + oldest.orElse(0));
        System.out.println("Youngest Age: " + youngest.orElse(0));

        scanner.close();

//        System.out.println("\nPeople with matching name:");
//        for (Person match : matches) {
//            System.out.println(match.getFullName());
//        }
//
//        int totalAge = 0;
//        int maxAge = Integer.MIN_VALUE;
//        int minAge = Integer.MAX_VALUE;
//
//        for (Person person : people) {
//            int age = person.getAge();
//            totalAge += age;
//            if (age > maxAge) maxAge = age;
//            if (age < minAge) minAge = age;
//        }
//
//        double averageAge = totalAge / (double) people.size();
//
//        System.out.printf("\nAverage Age: %.2f\n", averageAge);
//        System.out.println("Oldest Age: " + maxAge);
//        System.out.println("Youngest Age: " + minAge);
//
//        scanner.close();
    }
}
