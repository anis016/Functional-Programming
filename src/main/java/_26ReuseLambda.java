import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _26ReuseLambda {

    private static Predicate<String> getNameStartingWithS() {
        return name -> name.startsWith("S");
    }

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors = Arrays.asList("Nicole", "Nicholas", "Anis", "Gabriel", "Billy");
        final List<String> cheifs = Arrays.asList("World", "Mandella", "Bawl", "Nelson", "Neal");

        // create a generic Predicate for filtering
        // Predicate returns a value that is either true or false.
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");

        final List<String> friendsWithN = friends.stream().filter(startsWithN).collect(Collectors.toList());
        final List<String> friendsWithB = friends.stream().filter(startsWithB).collect(Collectors.toList());
        final List<String> friendsWithS = friends
                                                .stream()
                                                .filter(getNameStartingWithS())
                                                .collect(Collectors.toList());

        System.out.println(friendsWithN);
        System.out.println(friendsWithB);
        System.out.println(friendsWithS);

        /**
         * Though this removes some de-duplication but still there is a duplication of using
         * lambdas as we have to write lots of Predicates for each starting character.
         * Better version is define a function and pass character.
         */
        final List<String> friendsWithNBetter = friends
                .stream()
                .filter(checkIfStartsWith("N"))
                .collect(Collectors.toList());
        System.out.println(friendsWithNBetter);
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}
