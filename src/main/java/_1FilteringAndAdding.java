import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
* Task 1: Find out the total prices greater than 20, discounted by 10%.
*
* */
public class _1FilteringAndAdding {

    public static void main(String... args) {
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"),
                new BigDecimal("30"),
                new BigDecimal("17"),
                new BigDecimal("20"),
                new BigDecimal("15"),
                new BigDecimal("18"),
                new BigDecimal("45"),
                new BigDecimal("12")
        );

        // Earlier way
        BigDecimal totalDiscount1 = BigDecimal.ZERO;
        for (BigDecimal price: prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalDiscount1 = totalDiscount1.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println(totalDiscount1);

        // With Functional programming
        BigDecimal totaDiscount2 = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totaDiscount2);
    }
}
