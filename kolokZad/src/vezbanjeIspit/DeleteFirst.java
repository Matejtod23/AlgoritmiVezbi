package vezbanjeIspit;

import java.util.Scanner;

public class DeleteFirst {
        public static void DeleteFirstElement(SLL<Integer> list){
            SLLNode<Integer> first = list.getFirst();
            while (first.succ != null){
                if (first.element % 2 == 0 && first.succ.element % 2 == 0){
                    list.delete(first);
                }else if (first.element % 2 != 0 && first.succ.element % 2 != 0){
                    list.delete(first);
                }
                first = first.succ;
            }
            System.out.println(list.StringToPring());
        }

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            SLL<Integer> list = new SLL<Integer>();
            int n = input.nextInt();

            for (int i = 0; i < n; i++)
                list.insertLast(input.nextInt());

            DeleteFirstElement(list);

            input.close();
        }
    }

