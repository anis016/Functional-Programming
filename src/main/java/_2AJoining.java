import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class _2AJoining {

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // printing out normally each name separated with comma except the last name
        // ugly huh?
        int count = 0;
        for(String name: friends) {
            if(count < (friends.size() - 1)) {
                System.out.print(name + ", ");
            }
            count ++;
        }
        System.out.println(friends.get(friends.size()-1));

        // one liner with Join("", varargs)
        // elegant huh?
        System.out.println(String.join(", ", friends));

        // another way (functional way)
        // this way we can do other operations too
        System.out.println(friends.stream().map(String::toUpperCase).collect(joining(", ")));


    }
}
