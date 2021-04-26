package jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        Person ross = new Person(1, "Ross", 26);
        Person mark = new Person(2, "mark", 23);
        Person chandler = new Person(3, "chandler", 24);
        Person joey = new Person(4, "joey", 25);
        Person rachel = new Person(5, "rachel", 22);

        List<Person> list = Arrays.asList(ross, mark, chandler, joey, rachel);
        list.stream()
                .filter(u -> {return u.getId() % 2 == 0;})
                .filter(u -> { return u.getAge() > 24;})
                .map(u -> {return u.getName().toUpperCase();})
                .sorted()
                .forEach(System.out::println);
    }



}
