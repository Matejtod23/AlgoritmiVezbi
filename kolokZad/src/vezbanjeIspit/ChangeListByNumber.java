package vezbanjeIspit;

import java.util.Scanner;

public class ChangeListByNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0 ; i< n; i++){
            list.insertLast(input.nextInt());
        }
        int x = input.nextInt();
        changeList(list,x);
        System.out.println(list);
    }

    public static void changeList(SLL<Integer> list, int x){
        SLLNode<Integer> first = list.getFirst();
        for (int i = 0; i < list.size(); i++){
            if (first.element < x){
                first = first.succ;
            }else {
                list.insertLast(first.element);
                list.delete(first);
                first = first.succ;
            }
        }
    }
}
