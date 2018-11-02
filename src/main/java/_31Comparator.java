import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int ageDifference(Person other) {
        return age - other.age;
    }

    public String toString() {
        return String.format("%s - %d", name, age);
    }
}

public class _31Comparator {

    static void newline(String header) {

        System.out.println();
        System.out.println(header);
    }

    static void newline(int times) {
        for (int i = 0; i < times; i++)
            System.out.println();
    }

    static void newline() {
        System.out.println();
    }

    public static void main(String... args) {
        final List<Person> people = Arrays.asList(
                new Person("Sara", 21),
                new Person("John", 20),
                new Person("Greg", 32),
                new Person("Jane", 21)
        );
        System.out.println("Unsorted: " + people);

        newline("#Sorting Person list using Age (Ascending)");
        // sort the people using their age
        List<Person> ascendingAge = people
                        .stream()
                        .sorted((person1, person2) -> person1.ageDifference(person2))
                        .collect(toList());
        System.out.println(ascendingAge);

        // Above could be more simplified using method reference
        List<Person> ascendingAge2 = people
                .stream()
                .sorted(Person::ageDifference)
                .collect(toList());

        newline("#Sorting Person list using Age (Descending)");
        // reverse the sort i.e descending manner.
        List<Person> descendingAge = people
                        .stream()
                        .sorted((person1, person2) -> person2.ageDifference(person1))
                        .collect(toList());
        System.out.println(descendingAge);

        newline("#Sorting Person list using Comparator (Ascending and then Descending)");
        // Let's make the above ascending and descending of age comparision DRY
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        List<Person> ascendingAge3 = people
                .stream()
                .sorted(compareAscending)
                .collect(toList());
        System.out.println(ascendingAge3);

        List<Person> descendingAge2 = people
                .stream()
                .sorted(compareDescending)
                .collect(toList());
        System.out.println(descendingAge2);

        newline(2);

        newline("#Sorting Person list using Name (Ascending and then Descending)");
        Comparator<Person> compareAscendingName = (person1, person2) -> person1.getName().compareTo(person2.getName());
        Comparator<Person> compareDescendingName = compareAscendingName.reversed();

        // sort the people using their name
        List<Person> ascendingName = people
                .stream()
                .sorted(compareAscendingName)
                .collect(toList());
        System.out.println(ascendingName);

        List<Person> descendingName = people
                .stream()
                .sorted(compareDescendingName)
                .collect(toList());
        System.out.println(descendingName);
        newline();

        // making name comparision more concise using Comparator.comparing()
        Comparator<Person> compareAscendingName1 = Comparator.comparing(Person::getName);
        Comparator<Person> compareDescendingName1 = compareAscendingName1.reversed();

        // sort the people using their name
        List<Person> ascendingName1 = people
                .stream()
                .sorted(compareAscendingName1)
                .collect(toList());
        // System.out.println(ascendingName1);

        List<Person> descendingName1 = people
                .stream()
                .sorted(compareDescendingName1)
                .collect(toList());
        // System.out.println(descendingName1);

        newline("Finding the youngest Person in the list.");
        // .min() returns Optional object then we can use .ifPresent() method to check the smallest element
        people.stream()
              .min(Person::ageDifference)
              .ifPresent(youngest -> System.out.println("Youngest: " + youngest));

        people.stream()
                .max(Person::ageDifference)
                .ifPresent(oldest -> System.out.println("Oldest: " + oldest));

    }
}
