package zad8;
import java.util.Scanner;

// 1-> 2-> 3-> 4-> 5  to 2-> 1-> 4-> 3-> 5
// ako n % 2 == 0 ->  1-> 2-> 3-> 4-> 5-> 6  to 2-> 1-> 4-> 3-> 6-> 5

public class Kolokvium2018 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();
        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());
        System.out.println(list.toString());
        swap(list, n);
        System.out.println(list.toString());
        input.close();
    }

    private static void swap(SLL<Integer> list, int n) {
        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> next = curr.sledbenik;
        if (n % 2 != 0){
            while (n!=0){
                if (n == 1){
                    list.insertLast(curr.element);
                    list.delete(curr);
                    --n;
                    continue;
                }
                list.insertLast(next.element);
                list.delete(next);
                list.insertLast(curr.element);
                list.delete(curr);
                curr = next.sledbenik;
                next = next.sledbenik.sledbenik;
                n-=2;
            }
        }else {
            while (n!=0){
//                if(n == 2){
//                    list.insertLast(curr.element);
//                    list.delete(curr);
//                    list.insertLast(next.element);
//                    list.delete(next);
//                    n-=2;
//                    continue;
//                }
                list.insertLast(next.element);
                list.delete(next);
                list.insertLast(curr.element);
                list.delete(curr);
                curr = next.sledbenik;
                next = next.sledbenik.sledbenik;
                n-=2;
            }
        }
    }

}
