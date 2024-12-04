package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;
}

 class UserOperations {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1, "John", "Smith", 25, "USA"),
                new User(2, "Anna", "Johnson", 18, "Canada"),
                new User(3, "Mark", "Williams", 30, "UK"),
                new User(4, "Sophia", "Brown", 22, "USA"),
                new User(5, "Emma", "Jones", 35, "Australia")
        );


        System.out.println("Пользователи, отсортированные по lastName:");
        sortByLastName(users).forEach(System.out::println);


        System.out.println("\nПользователи, отсортированные по age:");
        sortByAge(users).forEach(System.out::println);


        System.out.println("\nВсе пользователи старше 7 лет: " + areAllUsersOlderThan(users, 7));


        System.out.println("\nСредний возраст пользователей: " + calculateAverageAge(users));


        System.out.println("\nКоличество разных стран проживания: " + countUniqueCountries(users));
    }


    public static List<User> sortByLastName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .collect(Collectors.toList());
    }


    public static List<User> sortByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }


    public static boolean areAllUsersOlderThan(List<User> users, int age) {
        return users.stream().allMatch(user -> user.getAge() > age);
    }


    public static double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }


    public static long countUniqueCountries(List<User> users) {
        return users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
    }
}
