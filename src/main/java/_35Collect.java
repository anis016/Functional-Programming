import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class _35Collect {

    public static void main(String... args) {

        final List<Person> people = Arrays.asList(
                new Person("Sara", 21),
                new Person("John", 20),
                new Person("Greg", 32),
                new Person("Jane", 21),
                new Person("Nate", 19),
                new Person("Natalia", 35)
        );
        System.out.println(people);

        // using forEach() method
        final List<Person> olderThan20 = new ArrayList<>();
        people.stream().filter(person -> person.getAge() > 20).forEach(person -> olderThan20.add(person));
        System.out.println(olderThan20);

        // using collect() method (better than forEach() method)
        // collect() need to know 3 things
        // 1) how to make a result container (example ArrayList::new)
        // 2) how to add a single element in the container (example ArrayList::add)
        // 3) how to merge one result container into another (example ArrayList::addAll)
        final List<Person> olderThan20_collect = people
                                                    .stream()
                                                    .filter(person -> person.getAge() > 20)
                                                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(olderThan20_collect);

        // overloaded operations for collect()
        // .collect(ArrayList::new, ArrayList::add, ArrayList::addAll) -> .collect(Collectors.toList())
        final List<Person> olderThan20_collect_overload = people
                                                            .stream()
                                                            .filter(person -> person.getAge() > 20)
                                                            .collect(Collectors.toList());
        System.out.println(olderThan20_collect_overload);

        // .groupingBy() takes a lambda expression or a method reference.
        // .groupingBy() returns the value of the property on which we want to do the grouping. Based on this
        // it puts the element in context into that bucket or group.
        Map<Integer, List<Person>> peopleByAge = people
                                                    .stream()
                                                    .collect(Collectors.groupingBy(
                                                         Person::getAge)
                                                    );
        System.out.println(peopleByAge);

        // another version of .groupingBy() that takes 2 parameters.
        // First it groups all the person by age, then instead of returning all the Person object it only returns
        // the Person object's property such as name.
        // here, .groupingBy() takes 2 parameters
        // 1) first is the Person's age, which is the criteria to group by.
        // 2) second is the Collector, which is the result of a call to the .mapping() function.
        //    .mapping() function takes 2 details.
        //    2.1) the property on which to map (name in this case).
        //    2.2) the type of the object to collect into, such as list or set.
        Map<Integer, List<String>> nameOfPeopleByAge = people
                                                        .stream()
                                                        .collect(Collectors.groupingBy(
                                                            person -> person.getAge(),
                                                            Collectors.mapping(Person::getName, Collectors.toList()))
                                                        );
        System.out.println(nameOfPeopleByAge);

        // another version of .groupingBy() where it takes a reducing operator than mapping operator
        // group the names by their first character and then get the oldest person in each group
        // here, the .groupingBy() takes 2 parameters
        // 1) first, group the names by their first letter. So, passed a lambda expressions that gets the first letter
        // 2) second parameter is not a reduce operation and reduces the elements to the oldest person.
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonOfEachLetter= people
                                                                    .stream()
                                                                    .collect(Collectors.groupingBy(
                                                                        person -> person.getName().charAt(0),
                                                                        Collectors.reducing(BinaryOperator.maxBy(byAge))
                                                                    ));
        System.out.println(oldestPersonOfEachLetter);
    }
}
