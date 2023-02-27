package zadListi;


/**
 За дадена листа од А0 до Аn да се испечати како резултат А0->Аn-1->А1->Аn-2->А2->...

 Влез:
 5
 1 2 3 4 5
 Излез:
 1->5->2->4->3
 Забелешка:
 Не смеат да се креираат нови листи
 Работа со јазлите
 */


//CODE


import java.util.Scanner;

public class ChangeList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();

        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        changeList(list);
        System.out.println(list);
        input.close();
    }
    //1 2 3 4 5
    //1 5 2 4 3
    private static void changeList(SLL<Integer> list) {
        SLLNode<Integer> first = list.getFirst();
        while (first != null){
            if((list.size() % 2 == 0) && (first.succ == null)){
                break;
            }
            list.insertFirst(first.element);
            list.delete(first);
            SLLNode<Integer> tmp = first.succ;
            if (first.succ!=null){
                while (tmp != null) {
                    if (tmp.succ == null) {
                        list.insertFirst(tmp.element);
                        list.delete(tmp);
                    }
                    tmp = tmp.succ;
                }
            }
            first = first.succ;
        }
        list.mirror();
    }
}


