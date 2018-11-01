import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _25FindingElements {

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // mapping with stream().filter() to find the elements starting with "N"
        final List<String> friendsWithN = friends
                                            .stream()
                                            .filter(name -> name.startsWith("N"))
                                            .collect(Collectors.toList());
        System.out.println(friendsWithN);
    }
}
