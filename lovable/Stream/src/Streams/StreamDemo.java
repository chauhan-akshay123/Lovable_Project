import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
      public static void main(String[] args){
          // feature introduced in  JAVA 8
          // process collections of data in a functional and declarative manner
         // Simplify Data Processing
         // Embrace Functional Programming
        // Improve Readability and Maintainability
       // Enable Easy Parallelism

       // What is Stream ?
       // -> sequence of elements supporting various operations

          // How to use Streams ?
       // Source, intermediate operations & terminal opreration

      List<Integer> numbers = Arrays.asList(1,2,3,4,5);
      System.out.println(numbers.stream().filter(x -> x%2==0).count());

      // Creating Streams
      // 1. From Collections
      List<Integer> list = Arrays.asList(1,2,3,4,5);
      Stream<Integer> stream = list.stream();
     // 2. From Arrays
      String[] array = {"a", "b", "c"};
      Stream<String> stream1 = Arrays.stream(array);
      // 3. Using Stream.of()
      Stream<String> stream2 = Stream.of("a", "b");
      // 4. Infinite streams
      Stream<Integer> generate = Stream.generate(() -> 1);
      Stream.iterate(1, x->x+1).limit(100).collect(Collectors.toList());
      




      }
}
