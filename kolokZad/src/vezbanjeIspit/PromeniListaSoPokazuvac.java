package vezbanjeIspit;

import java.util.Scanner;

public class PromeniListaSoPokazuvac {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++){
            list.insertLast(s.nextInt());
        }
        int k = s.nextInt();

        changeList(list, k);
        System.out.println(list);
    }

    public static void changeList(SLL<Integer> list, int k){
        if (k == 0)
            return;
        SLLNode<Integer> first = list.getFirst();
        list.deleteFirst();
        list.insertLast(first.element);
        changeList(list, k-1);
    }
}
