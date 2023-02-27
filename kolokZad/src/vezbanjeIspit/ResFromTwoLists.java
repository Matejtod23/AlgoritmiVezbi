package vezbanjeIspit;

import java.util.Scanner;

public class ResFromTwoLists {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        DLL<Integer> list1 = new DLL<>();
        DLL<Integer> list2 = new DLL<>();
        for (int i = 0; i < n; i++){
            list1.insertLast(s.nextInt());
        }
        int m = s.nextInt();
        for (int i = 0; i < m; i++){
            list2.insertLast(s.nextInt());
        }
        makeResultList(list1, list2);
    }

    public static void makeResultList(DLL<Integer> list1, DLL<Integer> list2){
        DLLNode<Integer> firstOfFirst = list1.getFirst();
        DLLNode<Integer> firtsOfSecond = list2.getFirst();
        DLL<Integer> result = new DLL<>();
        while(firstOfFirst != null && firtsOfSecond != null){
            if (firstOfFirst.element < firtsOfSecond.element && result.findCertainNode(firstOfFirst.element) == null){
                result.insertLast(firstOfFirst.element);
                firstOfFirst = firstOfFirst.succ;
            } else if (firstOfFirst.element > firtsOfSecond.element && result.findCertainNode(firtsOfSecond.element) == null) {
                result.insertLast(firtsOfSecond.element);
                firtsOfSecond = firtsOfSecond.succ;
            }else if (firstOfFirst.element == firtsOfSecond.element && result.findCertainNode(firstOfFirst.element) == null){
                result.insertLast(firstOfFirst.element);
                firstOfFirst = firstOfFirst.succ;
                firtsOfSecond = firtsOfSecond.succ;
            }else {
                firstOfFirst = firstOfFirst.succ;
                firtsOfSecond = firtsOfSecond.succ;
            }
        }
        if (firstOfFirst != null){
            while (firstOfFirst != null){
                if (result.findCertainNode(firstOfFirst.element) == null){
                    result.insertLast(firstOfFirst.element);
                }
                firstOfFirst = firstOfFirst.succ;
            }
        }else {
            while (firtsOfSecond != null){
                if (result.findCertainNode(firtsOfSecond.element) == null){
                    result.insertLast(firtsOfSecond.element);
                }
                firtsOfSecond = firtsOfSecond.succ;
            }
        }
        System.out.println(result);
    }


}
