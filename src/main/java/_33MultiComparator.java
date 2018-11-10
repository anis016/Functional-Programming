import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _33MultiComparator {

    public static void main(String... args) {

        final List<Person> people = Arrays.asList(
                new Person("Sara", 21),
                new Person("John", 20),
                new Person("Greg", 32),
                new Person("Jane", 21)
        );
        System.out.println("Unsorted: " + people);

        final Function<Person, String> byName    = Person::getName; // person -> person.getName();
        final Function<Person, Integer> byAge    = Person::getAge; // person > person.getAge();
        final Comparator<Person> byAgeDiff = Person::ageDifference; // (person1, person2) -> person1.ageDifference(person2);

        // joining helps in chaining of comparator.
        final List<Person> multiSorted = people
                                            .stream()
                                            .sorted(Comparator
                                                    .comparing(byAge)
                                                    .thenComparing(byName)
                                                    .thenComparing(byAgeDiff))
                                            .collect(Collectors.toList());

        String sorted = multiSorted.stream().map(name -> name.getName() + " - "+ name.getAge()).collect(Collectors.joining(", "));
        System.out.println(sorted);

        String sortedOnlyName = multiSorted.stream().map(name -> name.getName()).collect(Collectors.joining(", "));
        System.out.println(sortedOnlyName);
    }
}
