import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Task 1: Iterate through a list of names and convert to all Capital letters. Save this to another list.
 *
 * */
public class _22TransformingList {


    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        final List<String> upperCaseNames = new ArrayList<>();
        for (final String name : friends) {
            upperCaseNames.add(name.toUpperCase());
        }
        System.out.println(upperCaseNames);

        // functional way
        friends.stream().map(name -> upperCaseNames.add(name.toLowerCase()));
        System.out.println(upperCaseNames);
    }
}
