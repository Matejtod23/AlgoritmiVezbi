package vezbanjeIspit;

import java.util.Scanner;

public class SortTwoLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        DLL<Integer> list1 = new DLL();
        DLL<Integer> list2 = new DLL();
        DLL<Integer> result = new DLL();
        for(int i = 0; i < n; i++){
            list1.insertLast(input.nextInt());
        }        
        for(int i = 0; i < m; i++){
            list2.insertLast(input.nextInt());
        }
        DLLNode<Integer> first = list1.getFirst();
        DLLNode<Integer> toAdd = null;
        while(first != null){
            toAdd = null;
            DLLNode<Integer> firstOfSecond = list2.getFirst();
            while(firstOfSecond != null){
                if(firstOfSecond.element <= first.element){
                    toAdd = firstOfSecond;
                }
                firstOfSecond = firstOfSecond.succ;
            }
            if(toAdd == null){
                result.insertLast(first.element);
                list1.delete(first);
            }else{
                result.insertLast(toAdd.element);
                list2.delete(toAdd);
                continue;
            }
            first = first.succ;
        }
        if(list2.getSize() != 0){
            DLLNode<Integer> node = list2.getLast();
            while(node != null){
                result.insertLast(node.element);
                node = node.pred;
            }
        }
        System.out.println(result);
        result.mirror();
        System.out.println(result);
    }
}
