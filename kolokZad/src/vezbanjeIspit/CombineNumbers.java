package vezbanjeIspit;


import java.util.Scanner;

public class CombineNumbers {
    public static void changeList(SLL<Integer> list, int n){
        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> tmp;
        String num = "";
        int otherNotFirst = 0;
        while (curr != null){
            if (curr.element == -1){
                list.insertBefore(Integer.valueOf(num), curr);
                num = "";
                otherNotFirst = 1;
            }
            if (curr.element != -1){
                num += curr.element;
            }
            if (otherNotFirst == 1){
                list.delete(curr);
                curr = curr.succ;
            }else {
                curr = curr.succ;
                list.deleteFirst();
            }
        }
        if (!num.equals("")){
            list.insertLast(Integer.valueOf(num));
        }
        System.out.println(list.StringToPring());
    }




    public static void main(String[] args) {

        SLL<Integer> list = new SLL<Integer>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(input.nextInt());
        }

        changeList(list, n);

        input.close();
    }

}