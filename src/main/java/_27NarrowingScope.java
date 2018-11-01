import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class _27NarrowingScope {

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

         /*
           // More concise version
           final Function<String, Predicate<String>> startsWithLetter =
                 (String letter) -> (String name) -> name.startsWith(letter);
          */

        friends
                .stream()
                .filter(startsWithLetter.apply("N"))
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        friends
                .stream()
                .filter(startsWithLetter.apply("B"))
                .forEach(name -> System.out.print(name + " "));
    }
}
