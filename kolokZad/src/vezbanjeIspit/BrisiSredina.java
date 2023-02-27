package vezbanjeIspit;

import java.util.Scanner;

public class BrisiSredina {

    public static void removeMiddleNode(SLL<Integer> list , int timesDeleted){
        SLLNode<Integer> first;
        while (timesDeleted > 0){
            first = list.getFirst();
            int listSize = list.size();
            int counter = 0;
            while (counter != (listSize/2)-1){
                first = first.succ;
                counter++;
            }
            if (listSize % 2 == 0){
                SLLNode<Integer> left;
                SLLNode<Integer> right;
                left = first;
                right = first.succ;
                if (left.element < right.element){
                    list.delete(left);
                }else if (right.element < left.element){
                    list.delete(right);
                }else {
                    list.delete(left);
                }
            }else {
                SLLNode<Integer> nodeToDelete = first.succ;
                list.delete(nodeToDelete);
            }
            timesDeleted--;
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SLL<Integer> list = new SLL<Integer>();
        int n = input.nextInt();

        for (int i = 0; i < n; ++i)
            list.insertLast(input.nextInt());
        removeMiddleNode(list, input.nextInt());
        input.close();
    }
}
