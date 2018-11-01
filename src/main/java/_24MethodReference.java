import java.util.Arrays;
import java.util.List;

public class _24MethodReference {

    public static int countMyName(String string) {
        return string.length();
    }

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // mapping with stream().map() and using user defined methods reference
        friends.stream().map(_24MethodReference::countMyName).forEach(name -> System.out.println(name));

        // mapping with stream().map() and using String.toUpperCase() methods reference
        friends.stream().map(String::toUpperCase).forEach(name -> System.out.println(name));

    }
}
