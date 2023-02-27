package vezbanjeIspit;

import java.util.Scanner;

public class SwapList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();
        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        swap(list, n);
        input.close();
    }

    private static void swap(SLL<Integer> list, int n) {
        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> next = curr.succ;
        if (n % 2 == 0){
            while (next.succ != null) {
                list.insertAfter(next.element, curr);
                list.insertBefore(curr.element, next);
                list.delete(curr);
                list.delete(next);
                curr = curr.succ.succ.succ;
                next = next.succ.succ;
            }
        }else {
            while (next != null) {
                list.insertAfter(next.element, curr);
                list.insertBefore(curr.element, next);
                list.delete(curr);
                list.delete(next);
                curr = curr.succ.succ.succ;
                next = next.succ.succ;
            }
        }
        System.out.println(list);
    }
}
