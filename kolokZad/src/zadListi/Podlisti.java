package zadListi;

import java.util.Scanner;

/** Подлисти
 Да се избришат сите подлисти на една листа во друга листа
 input:
 20
 7 6 7 6 5 1 3 7 6 7 6 7 6 5 4 7 6 7 6 5
 5
 7 6 7 6 5
 output:
 1 3 7 6 4
 */


//CODE
public class Podlisti {

    private static void brisiPodlisata(SLL<Integer> list, SLL<Integer> podlista) {
        SLLNode<Integer> first = list.getFirst();
        SLLNode<Integer> firstP = podlista.getFirst();
        int flag = 1, isBreak = 1;
        while (first!=null){
            if (first.element == firstP.element){
                SLLNode<Integer> tmp = first;
                while (firstP!=null){
                    if (tmp.element != firstP.element) {
                        isBreak = 0;
                        break;
                    }
                    firstP = firstP.succ;
                    tmp = tmp.succ;
                }
                if (isBreak==1){
                    flag = 0;
                }
                if (flag == 0){
                    int count = podlista.size();
                    while (count>0){
                        list.delete(first);
                        first = first.succ;
                        count--;
                    }
                    flag = 1;
                    firstP = podlista.getFirst();
                    continue;
                }
                isBreak=1;
            }
            firstP = podlista.getFirst();
            first = first.succ;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();
        SLL<Integer> podlista = new SLL<Integer>();

        int n = input.nextInt();
        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        int m = input.nextInt();
        for (int i = 0; i < m; i++)
            podlista.insertLast(input.nextInt());

        brisiPodlisata(list, podlista);
        System.out.println(list);
        input.close();
    }
}
