package vezbanjeIspit;

import java.util.Scanner;

public class ChangeList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();

        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        changeList(list);
        input.close();
    }
    public static void changeList(SLL<Integer> list){
        SLLNode<Integer> first = list.getFirst();
        while (first.succ != null){
            SLLNode<Integer> iterator = list.getFirst();
            while (iterator.succ != null){
                iterator = iterator.succ;
            }
            list.insertAfter(iterator.element, first);
            list.delete(iterator);
            if (first.succ.succ != null){
                first = first.succ.succ;
            }else {
                first = first.succ;
            }
        }
        System.out.println(list);
    }


}
