package vezbanjeIspit;

import java.io.Writer;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Occurencies {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
//        while (input.hasNext()){
//                list.add(input.nextInt());
//        }
        int[] arr = {1,2,2,1,1,3};
        for (int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
        Map<Integer, Long> frequencyByNumber = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        boolean ifDistinct = frequencyByNumber.values().stream()
                .collect(Collectors.toSet())
                .size() == frequencyByNumber.size();
        System.out.println(ifDistinct);
    }
}
