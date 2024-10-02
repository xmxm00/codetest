package playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPlayground {
    public static void main(String[] args) {
//        IntStream lotto = new Random().ints(1, 46);
//        lotto.distinct().limit(6).sorted()
//                .forEach(System.out::println);
//        String[] strArr = {"a", "b", "c", "d"};
//        System.out.println(Arrays.toString(strArr));
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> intStream = list.stream();
//        intStream.forEach(System.out::println);
//        intStream.forEach(System.out::println);
//        IntStream intStream = IntStream.rangeClosed(1, 10);
//        intStream.filter(i->i%2!=0).filter(i->i%3!=0)
//                .forEach(System.out::print);
        List<String> strList = Arrays.asList("타코", "햄버거", "피자");
        Collections.shuffle(strList);
        System.out.println(strList.get(0));

    }
}
