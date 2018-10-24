import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Task 1: Iterating a List
 *
 * */
public class _21IteratingList {

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // Earlier way (Iterating and printing)
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
        System.out.println();

        // Another way
        for (String friend : friends) {
            System.out.println(friend);
        }
        System.out.println();

        // Functional way (Anonymous inner class)
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });
        System.out.println();

        // The above Functional way could be translated using lambda like below
        friends.forEach((final String name) -> System.out.println(name));
        System.out.println();

        // More shorter version of the above function
        friends.forEach(System.out::println);

    }
}
