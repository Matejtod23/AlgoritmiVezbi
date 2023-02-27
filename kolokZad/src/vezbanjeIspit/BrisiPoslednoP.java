package vezbanjeIspit;

import java.util.Scanner;

public class BrisiPoslednoP{
    public static void main(String[] args) {
        SLL<Integer> list = new SLL();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int b = input.nextInt();
            list.insertLast(b);
        }        
        int key = input.nextInt();
        deleteDuplicates(list, key);
    }

    public static void deleteDuplicates(SLL list, int key){
        SLLNode<Integer> first = list.getFirst();
        SLLNode<Integer> nodeToDelete = null;
        while(first != null){
            if(first.element == key)
                nodeToDelete = first;
            first = first.succ;
        }
        list.delete(nodeToDelete);
        System.out.println(list.StringToPring());
    }
}