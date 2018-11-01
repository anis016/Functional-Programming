import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class _29Reduce {

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scottzz");

        Integer sum = friends
                .stream()
                .mapToInt(name -> name.length())
                .sum();
        System.out.println("Total number of characters in all names: " + sum);

        OptionalInt max = friends
                .stream()
                .mapToInt(name -> name.length())
                .max();
        System.out.println("Biggest name length: " + max.getAsInt());

        // finding the longest name
        // .reduce() returns Optional<T> object
        Optional<String> longName = friends
                .stream()
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        longName.ifPresent(name -> System.out.println(name));

        // no need to use orElse() function as there will be always 1 name present.
        // System.out.println(longName.orElse("Not found"));

        // passing a default value to .reduce()
        // This default value is set if nothing else satisfies the condition.
        // If used default value then this returns a data type.
        String longNameWithDefault = friends
                .stream()
                .reduce("Steve Rogers", (name1, name2) ->
                name1.length() > name2.length() ? name1 : name2);
        System.out.println(longNameWithDefault);
    }
}
