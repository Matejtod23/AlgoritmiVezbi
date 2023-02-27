package zadListi;

/** Подели според самогласки
 Дадена е двострано поврзана листа чии што јазли содржат по еден знак (буква). Листата треба да се подели на две резултантни листи, т.ш. во првата резултантна листа ќе бидат бидат сместени самогласките од влезната листа, а во втората – согласките.
 Јазлите во резултантните листи се додаваат наизменично почнувајќи од почетокот и крајот на влезната листа (т.е. прво се разгледува првиот елемент од листата и се додава во соодветната резултантна листа, па последниот, па вториот итн...)
 Во првиот ред од влезот се дадени буквите од кои се составени јазлите по редослед од влезната листа. Во првиот ред од излезот треба да се испечатат јазлите по редослед од првата резултантна листа (т.е. самогласките), во вториот ред од втората (т.е. согласките) .
 Име на класа (за Java): PodeliSamoglaski
 Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.
 Sample input
 abcde
 Sample output
 a e
 b d c
 Sample input
 oagawtff
 Sample output
 o a a
 f f g t w
 */

//CODE

import javax.print.DocFlavor;
import java.util.Scanner;

public class PodeliSporedParnost {

    public static boolean isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }

    public static void PodeliSporedParnost(DLL<Character>list,int n){
        DLLNode<Character> first = list.getFirst();
        DLLNode<Character> last = list.getLast();
        DLL<Character> samoglaski = new DLL<>();
        DLL<Character> soglaski = new DLL<>();
        int counter = n;
        while (counter>0){
            if (n%2!=0 && counter==1){
                if (isVowel(first.element)){
                    soglaski.insertLast(first.element);
                }else {
                    samoglaski.insertLast(first.element);
                }
                break;
            }
            if (isVowel(first.element)){
                soglaski.insertLast(first.element);
            }else {
                samoglaski.insertLast(first.element);
            }
            if (isVowel(last.element)){
                soglaski.insertLast(last.element);
            }else {
                samoglaski.insertLast(last.element);
            }
            first = first.succ;
            last = last.pred;
            counter-=2;
        }
        System.out.println(soglaski);
        System.out.println(samoglaski);
    }


    public static void main(String[] args) {
        DLL<Character> list = new DLL<Character>();

        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        for (int i = 0; i < expression.length(); i++)
            list.insertLast(expression.charAt(i));

        PodeliSporedParnost(list, expression.length());
        input.close();
    }
}
