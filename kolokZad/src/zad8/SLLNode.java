package zad8;

public class SLLNode<E> {
    public E element;
    public SLLNode<E> sledbenik;

    public SLLNode(E elem, SLLNode<E> sledbenik) {
        this.element = elem;
        this.sledbenik = sledbenik;
    }

    @Override
    public String toString() {
        return "" + element + " " + sledbenik;
    }
}
