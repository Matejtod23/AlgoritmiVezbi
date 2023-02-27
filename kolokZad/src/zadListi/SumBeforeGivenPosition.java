package zadListi;

import java.util.Scanner;

public class SumBeforeGivenPosition {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        sumBefore(list);
        System.out.println(list);
        input.close();
    }

    private static void sumBefore(SLL<Integer> list) {
        SLLNode<Integer> first = list.getFirst();
        int count = 0, sum = 0;
        while (first!=null){
            count = first.element;
            sum = 0;
            while (first != null && count>0){
                sum += first.element;
                first = first.succ;
                count--;
            }
            list.insertBefore(sum, first);
        }
    }
}
