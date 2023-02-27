package zadListi;


/**Дадена е еднострана/двострана листа која содржи едноцифрени броеви и меѓу нив е и -1.
 * Да се модифицира листата на тој начин што ќе се форматираат броеви од тие цифри се додека не се стигне до бројот -1.
 * Кога ќе се стигне до тој број се прeкинува и се брише -1 и се продолжува во форматирање на броеви од наредните цифри (постапката се повторува).

 Влез:
 14
 1 2 3 -1 5 -1 6 7 4 8 9 -1 9 8

 123 5 67489 98

 19
 1 2 3 -1 5 6 -1 3 4 -1 7 4 8 9 -1 9 -1 8 -1
 Излез:
 123 56 34 7489 9 8
 */


//CODE

import java.util.Scanner;

public class CombineNumbers {


    public static void main(String[] args) {

        SLL<Integer> list = new SLL<Integer>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            list.insertLast(input.nextInt());
        }

        changeList(list, n);
        System.out.println(list.toString());

        input.close();
    }

    private static void changeList(SLL<Integer> list, int n) {
        SLLNode<Integer> first = list.getFirst();
        String pom = "";
        while (first!=null){
            if (first.element != -1){
                pom+=first.element;
                list.delete(first);
            } else if (first.element == -1) {
                    list.delete(first);
                    list.insertFirst(Integer.valueOf(pom));
                    pom = "";

            }
            first = first.succ;
        }
        list.insertFirst(Integer.valueOf(pom));
        list.mirror();
    }

}
