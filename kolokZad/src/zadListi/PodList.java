package zadListi;

import java.util.Scanner;

/**Подлиста на листа
 Да се провери дали една листа е подлиста на друга листа
 Влез:
 11
 7 3 5 6 5 6 5 6 4 3 2
 5
 5 6 5 6 4
 Излез:
 True
 Влез:
 11
 7 3 5 6 5 6 5 6 4 3 2
 7
 5 6 5 6 4 1 3
 Излез:
 false
 */


//CODE

public class PodList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();
        DLL<Integer> temp = new DLL<Integer>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        int m = input.nextInt();
        for (int i = 0; i < m; i++)
            temp.insertLast(input.nextInt());

        System.out.println(daliPodLista(list, temp, m));
        input.close();
    }

    private static boolean daliPodLista(DLL<Integer> list, DLL<Integer> temp, int m) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> firstT = temp.getFirst();
        int istiSe = 0;
        while (first!=null){
            if (first.element == firstT.element){
                DLLNode tmp = first;
                while (firstT != null){
                    if (tmp.element != firstT.element){
                        istiSe = 1;
                        break;
                    }
                    istiSe = 0;
                    firstT = firstT.succ;
                    tmp = tmp.succ;
                }
            }
            if(istiSe == 0){
                return true;
            }
            firstT = temp.getFirst();
            first = first.succ;
        }
        if (istiSe == 1){
            return false;
        }else {
            return true;
        }
    }
}
