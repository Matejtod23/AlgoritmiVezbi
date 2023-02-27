package vezbanjeIspit;

import java.util.Scanner;



public class SpecialSLLJoin<E> {



    public SLL<E> specialJoin(SLL<E> list1, SLL<E> list2) {
        SLLNode<E> firstList1 = list1.getFirst();
        SLLNode<E> firstList2 = list2.getFirst();
        SLL<E> resultList = new SLL<>();
        while (firstList1 != null || firstList2 != null){
            int i =0; int j = 0;
            while (i < 2 && firstList1 != null){
                resultList.insertLast(firstList1.element);
                firstList1 = firstList1.succ;
                i++;
            }
            while (j < 2 && firstList2 != null){
                resultList.insertLast(firstList2.element);
                firstList2 = firstList2.succ;
                j++;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list1 = new SLL<>();
        for(int i=0;i<n;i++) {
            list1.insertLast(input.nextInt());
        }

        n = input.nextInt();

        SLL<Integer> list2 = new SLL<>();
        for(int i=0;i<n;i++) {
            list2.insertLast(input.nextInt());
        }

        SpecialSLLJoin<Integer> tmp = new SpecialSLLJoin<>();

        System.out.println(tmp.specialJoin(list1, list2));
    }


}
