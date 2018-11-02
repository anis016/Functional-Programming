
public class _31IteratingString {

    private static void printChar(int aChar) {
        System.out.println((char) aChar);
    }

    private static void newline() {
        System.out.println();
    }

    public static void main(String... args) {

        String str = "hel10";
        str.chars().forEach(System.out::println); // this shows the ASCII for each character in the String.
        newline();
        str.chars().forEach(_31IteratingString::printChar);

        // .chars() returns the stream(). we can then work on it further, example filtering out the digits.
        newline();
        str.chars().filter(Character::isDigit).forEach(_31IteratingString::printChar);
    }
}
