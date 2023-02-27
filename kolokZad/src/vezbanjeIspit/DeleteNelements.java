package vezbanjeIspit;

import java.util.Scanner;

public class DeleteNelements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++){
            list.insertLast(input.nextInt());
        }
        if (list.size() == 0){
            System.out.println("Prazna lista");
        }else {
            removeNode(list);
        }
    }

    private static void removeNode(SLL<Integer> list) {
        int tmp = 0;
        int howMuchToJump = 1;
        SLLNode<Integer> first = list.getFirst();
        while (first != null){
            if (howMuchToJump == tmp){
                howMuchToJump += 1;
                tmp = 0;
                list.delete(first);
            }else {
                tmp++;
            }
            first = first.succ;
        }
        System.out.println(list.StringToPring());
    }
}
