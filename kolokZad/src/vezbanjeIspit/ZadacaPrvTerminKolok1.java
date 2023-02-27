package vezbanjeIspit;

import java.util.Scanner;

public class ZadacaPrvTerminKolok1 {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();
        Array<SLL<Integer>> lists = new Array<>(10);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int howMuchFirst = n % 10;
        int size = (int) Math.ceil((double) n/10);
        if (size == 10)
            size = 1;
        for (int i = 0; i < n; i++){
            list.insertLast(s.nextInt());
        }
        SLLNode<Integer> first = list.getFirst();
        for (int i = 0; i < 10; i++){
            SLL<Integer> tmplist = new SLL<>();
            int tmp = size;
            if(howMuchFirst != 0){
                while (tmp != 0 && first != null) {
                    tmplist.insertLast(first.element);
                    first = first.succ;
                    tmp--;
                }
                howMuchFirst--;
            }else {
                while (tmp - 1 != 0 && first != null){
                    tmplist.insertLast(first.element);
                    first = first.succ;
                    tmp--;
                }
            }
            lists.insertLast(tmplist);
        }
        System.out.println(lists);
    }


}
