import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class _34Function {

    /**
     * public interface Function<T, R> { ... }
     * is an interface method that receives one value T and returns another value R.
     * This is similar to the Map.computeIfAbsent() function.
     *
     */
    public static void main(String... args) {

        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("Jane", 3);
        // computeIfAbsent() returns a value from a map by key,
        // but if the key value is not present in the map then it returns some function to compute a value.
        Integer value = nameMap.computeIfAbsent("Jane", s -> s.length());
        // Jane key is present in the map, hence get the value for that key from the map which is 3
        System.out.println(value);

        value = nameMap.computeIfAbsent("John Doe", s -> s.length()); // String::length
        // John Doe is not present, hence use the function which is applied to the key to compute a value.
        System.out.println(value);

        // the Function takes in Integer and spits out a String. So it takes an Integer and returns String.
        Function<Integer, String> integerToString = String::valueOf; // s -> String.ValueOf(s)
        // the Function takes in String and spits out String. So it takes a String and puts a quote around.
        Function<String, String> quote = s -> "'" + s + "'";

        // compose() method allows to combine several functions into one and execute them sequentially.
        // so, first quote function is called and then transformed to String by calling String.valueOf(s).
        Function<Integer, String> quoteIntToString = quote.compose(integerToString);
        System.out.println(quoteIntToString.apply(5));
    }
}
