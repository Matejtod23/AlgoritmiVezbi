package vezbanjeIspit;

import java.util.Scanner;

public class PalindromeDLL {

    public static int isItPalindrome(DLL<Integer> list){
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        int isPalindrome = 1;
        while (first != null && last != null){
            if (first.element != last.element){
                isPalindrome = -1;
            }
            first = first.succ;
            last = last.pred;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }

}
