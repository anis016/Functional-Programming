import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class _27NarrowScope {

    final Function<String, Predicate<String>> startsWithLetter =
            (String letter) -> {
                Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                return checkStarts;
            };

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    }
}
