import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class _28Optional {

    // more on Optional: https://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        pickName(friends, "N");
    }

    public static void pickName(List<String> names, String startingLetter) {

        // filter() method first grabs everything using the pattern
        // findFirst() method of the Stream class picks the first value from that collection
        // and then it returns Optional object.
        final Optional<String> foundName = names
                .stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        /*
        The Optional class is useful whenever the result may be absent. It protects us
        from getting a NullPointerException by accident and makes it quite explicit to the
        reader that "no result found" is a possible outcome.
         */
        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("no result found")));

        // isPresent() returns a boolean value true/false if there is anything inside
        // Optional object.
        System.out.println(foundName.isPresent());

        // get() gets the current value inside the Optional object. However, use this with
        // isPresent() method or else it will throw NoSuchElementException. Better to use
        // Optional orElse() method.
        System.out.println(foundName.get());

        // ifPresent()
        foundName.ifPresent(name -> System.out.println(name));
    }
}
