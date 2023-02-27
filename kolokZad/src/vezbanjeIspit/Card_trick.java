package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Card_trick {
    public static int count(int N){
        ArrayStack<Integer> firstCards = new ArrayStack<>(7);
        ArrayQueue<Integer> cardDeck = new ArrayQueue<>(51);
        int mesanja = 0;
        for (int i = 1; i <= 51; i++){
            cardDeck.enqueue(i);
        }
        while (N != cardDeck.peek()){
            for (int i = 1; i <= 7; i++){
                firstCards.push(cardDeck.dequeue());
            }
            while (!firstCards.isEmpty()){
                cardDeck.enqueue(firstCards.pop());
                cardDeck.enqueue(cardDeck.dequeue());
            }
            mesanja++;
        }
        return mesanja;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}