import java.util.*;
import java.util.stream.Collectors;

public class _23forEachLoop {

    public static void main(String... args) {

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        // normal forEach loop
        friends.forEach(name -> System.out.println(name));

        // filtering with if in forEach
        final List<String> nameStartsWithN = new ArrayList<>();
        friends.forEach(name -> {
            if(name.startsWith("N")) {
                nameStartsWithN.add(name);
            }
        });
        System.out.println(nameStartsWithN);

        List<String> upper = new ArrayList<>();
        friends.stream().map(String::toUpperCase).forEach(upper::add);
        System.out.println(upper);

        // filtering with stream().filter()
        final List<String> nameStartsWithN2 = new ArrayList<>();
        friends.stream().filter(name -> name.startsWith("N")).forEach(name -> nameStartsWithN2.add(name));
        System.out.println(nameStartsWithN2);

        // mapping with stream().map() and collecting in the end
        final List<String> nameStartsWithN3 = friends
                .stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
        System.out.println(nameStartsWithN3);

        // mapping with directly using forEach loop
        final List<String> upperCaseNames = new ArrayList<>();
        friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));
        System.out.println(upperCaseNames);

        // mapping with stream().map()
        final List<String> upperCaseNames2 = new ArrayList<>();
        friends.stream().map(name -> name.toUpperCase()).forEach(name -> upperCaseNames2.add(name));
        System.out.println(upperCaseNames2);

        // mapping with stream().map()
        friends.stream().map(name -> name.length()).forEach(name -> System.out.print(name + " "));

        // mapping with stream().map() and collecting in the end
        final List<String> upperCaseNames3 = friends
                .stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperCaseNames3);

        // Working with HashMap
        Map<String, String> names = new HashMap<>();
        names.put("Sayed Anisul", "Hoque");
        names.put("Jane", "Doe");

        names.values().stream().forEach(lastName -> System.out.println(lastName)); // use values() to get values
        names.keySet().stream().forEach(firstName -> System.out.println(firstName)); // use keySet() to get keys
    }
}
