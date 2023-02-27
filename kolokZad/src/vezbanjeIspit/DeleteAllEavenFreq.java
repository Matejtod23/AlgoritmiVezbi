package vezbanjeIspit;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Scanner;

public class DeleteAllEavenFreq {

    public static void deleteEven(SLL list){
        HashMap<Integer, Integer> numsByFreq = new HashMap<>();
        SLLNode<Integer> first = list.getFirst();
        while(first != null){
            int num = first.element;
            numsByFreq.computeIfPresent(num,(k,v) -> v += 1);
            numsByFreq.putIfAbsent(num, 1);
            first = first.succ;
        }
        first = list.getFirst();
        while(first != null){
            if(numsByFreq.get(first.element) % 2 == 0){
                list.delete(first);
            }
            first = first.succ;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i = 0; i < n; i++){
            int num = scanner.nextInt();
            list1.insertLast(num);
        }


        deleteEven(list1);
        System.out.println(list1);
    }
}
