package vezbanjeIspit;

import java.util.Scanner;

public class DeleteDuplicate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL();
        for(int i = 0 ; i < n; i++){
            list.insertLast(input.nextInt());
        }
        int key = input.nextInt();
        deleteDuplicates(list, key);
        System.out.println(list);
    }

    public static void deleteDuplicates(SLL list, int k){
        SLLNode<Integer> first = list.getFirst();
        int counter = 0;
        while(first != null){
            if(first.element == k){
                counter++;
            }
            if(first.succ != null){
                if(first.succ.element == k && counter > 0){
                    if(first.succ.succ != null){
                        first.succ = first.succ.succ;
                        //first.succ.succ = null;
                    }else{
                        first.succ = null;
                    }
                }
            }
            first = first.succ;
        }
    }
    
}
