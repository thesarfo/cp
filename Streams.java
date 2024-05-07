import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) throws IOException{
        // 1. Integer Stream
        IntStream
        .range(1, 10)
        .forEach(System.out::print);
        System.out.println();

        // 2. Integer Stream with skip
        IntStream
        .range(0, 10)
        .skip(5) // skip the first 5 elements and print the rest in the range
        .forEach(x -> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(
            IntStream
            .range(1, 5) // prints the sum of ints 1-4
            .sum());
        System.out.println();
    }
}
