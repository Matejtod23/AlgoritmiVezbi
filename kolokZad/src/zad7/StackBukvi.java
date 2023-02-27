package zad7;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class StackBukvi {

    public static void main(String[] args) throws IOException {
        char [] niza = new char[100];

        Scanner f=new Scanner(System.in);
        String st=f.next();
        niza=st.toCharArray();

        int rez= chekT(niza);
        System.out.println(rez);
    }

    private static int chekT(char[] niza) {
        int counter1 = 0, brPojavuvanja = 0, now = 0;
        ArrayStack stack = new ArrayStack<>(niza.length);
        for (int i = 0; i < niza.length; i++){
            if (niza[i] == 'S'){
                for (int j = i + 1; j < niza.length; j++){
                    if (niza[j] == 'S')
                        break;
                    stack.push(niza[j]);
                }
                while (!stack.isEmpty()){
                    if ((char)stack.peek() == 'T' || (char)stack.peek() == 't'){
                        counter1++;
                    }
                    stack.pop();
                }
                if (brPojavuvanja == 0){
                    brPojavuvanja = counter1;
                }
                now = counter1;
            }

            counter1 = 0;
            if (brPojavuvanja != 0 && (brPojavuvanja != now)) {
                return 0;
            }
        }
        return 1;
    }


}