package zadHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    // Each MapEntry object is a pair consisting of a key (a Comparable
    // object) and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Napishete ja vie HASH FUNKCIJATA
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is
        // equal
        // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntry replace the existing entry ...
                curr.element = newEntry;
                return;
            }
        }
        // Insert newEntry at the front of the 1WLL in bucket b ...
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}

public class KumanovskiDijalekt {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());

        String rechnik[]=new String[N];
        for(int i=0;i<N;i++){
            rechnik[i]=br.readLine();
        }

        String tekst=br.readLine();

        //Vasiot kod tuka
        CBHT<String, String> map = new CBHT<>(N*2);
        for(int i = 0; i<N; i++){
            String[] parts = rechnik[i].split("\\s+");
            map.insert(parts[0], parts[1]);
        }
        String[] parts = tekst.split("\\s+");
        if (N == 0){
            System.out.println(tekst);
        }else {
            for (int i = 0; i < parts.length; i++){
                String word = parts[i];
                char whatPunct = 0;
                int isUp = 0;
                int hasPunct = 0;
                if (!Character.isAlphabetic(word.charAt(word.length() -1))){
                    hasPunct = 1;
                    whatPunct = word.charAt(word.length()-1);
                    word = word.substring(0, word.length()-1);
                }
                SLLNode<MapEntry<String, String>> node = map.search(word.toLowerCase());
                if (node != null){
                    if (Character.isUpperCase(word.charAt(0))){
                        isUp = 1;
                    }
                    if (isUp == 1 && hasPunct == 1){
                        String wordToPrint = node.element.value;
                        String s1 = wordToPrint.substring(0,1).toUpperCase();
                        String s2 = wordToPrint.substring(1);
                        wordToPrint = s1 + s2;
                        System.out.print(wordToPrint + whatPunct + " ");
                    } else if (isUp == 1) {
                        String wordToPrint = node.element.value;
                        String s1 = wordToPrint.substring(0,1).toUpperCase();
                        String s2 = wordToPrint.substring(1);
                        wordToPrint = s1 + s2;
                        System.out.print(wordToPrint + " ");
                    } else if (hasPunct == 1) {
                        System.out.print(node.element.value + whatPunct + " ");
                    }else{
                        System.out.print(node.element.value + " ");
                    }
                }else {
                    System.out.print(parts[i] + " ");
                }

            }

        }
        }
}

