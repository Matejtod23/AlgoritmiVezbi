package zadListi;

import java.util.Scanner;

/**
 * Дадена е еднострано поврзана листа SLL чии што јазли содржат по еден природен број. Да се трансформира листата така што на непарните позиции (сметајќи од лево на десно, со почеток 0) ќе се постави збирот од сите елементи кои се наоѓаат помеѓу позициите M и N.
 * Влез: Во првиот ред од влезот е даден бројот на елементи во листата, а потоа самите елементи на листата секој во нов ред. По внесувањето на листата
 * во посебен ред е даден бројот М, а во наредниот бројот N.
 * Пример:
 * Влез:
 * 8 //број на елементи на листата
 * 1 //елементите на листата ...
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 3 //бројот M
 * 6 //бројот N
 * Излез:
 * 1 22 3 22 5 22 7 22
 * Објаснување: M=3, N=6
 * Елементите кои се наoѓаат во интервалот од 3-от до 6-от елемент се : 4, 5, 6, 7, нивниот збир е: 4 + 5+6+7 =22
 * Со замена на јазлите во листата се добива 1 22 3 22 5 22 7 22
 * Забелешка: При реализација на задачата не е дозволено менување на вредностите на јазлите во листата. Манипулациите се вршат врз цели јазли. На располагање од структурите имате само ЕДНА еднострано поврзана листа, SLL.
 * Име на класа (Јава): SumList
 * Sample input
 * 8
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 3
 * 6
 * Sample output
 * 1 22 3 22 5 22 7 22
 */

//CODE


public class sumListi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SLL<Integer> list = new SLL<Integer>();
        int size = input.nextInt();

        for (int i = 0; i < size; i++)
            list.insertLast(input.nextInt());

        int m = input.nextInt();
        int n = input.nextInt();
        SumList(list, m, n);
        System.out.println(list);
        input.close();
    }

    private static void SumList(SLL<Integer> list, int m, int n) {
        SLLNode<Integer> first = list.getFirst();
        int sum = 0, counter = 0;
        while (first != null) {
            if (counter == m) {
                for (int i = m; i <= n; i++) {
                    sum += first.element;
                    first = first.succ;
                }
                break;
            }
            counter++;
            first = first.succ;
        }
        SLLNode tmp = new SLLNode<Integer>(sum, null);
        first = list.getFirst();
        counter = 0;
        while (first!=null){
            if (counter % 2 != 0){
//                tmp.succ = first.succ;
//                first = tmp;
                list.insertAfter(sum, first);
                list.delete(first);
                first = first.succ;
            }
            first = first.succ;
            counter++;
        }
    }
}
