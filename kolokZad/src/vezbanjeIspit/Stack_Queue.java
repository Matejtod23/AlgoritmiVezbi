package vezbanjeIspit;

import java.util.NoSuchElementException;

interface Stack<E> {
    public boolean isEmpty();

    public E peek();

    public void clear();

    public void push(E x);

    public E pop();

    public int len();
}

interface Queue<E> {
    public boolean isEmpty();

    public int size();

    public E peek();

    public void clear();

    public void enqueue(E x);

    public E dequeue();

    public int len();
}

class ArrayQueue<E> implements Queue<E> {
    E[] elems;
    int length, front, rear;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public int len() {
        return elems.length;
    }

    public E peek() {
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        length = 0;
        front = rear = 0;
    }

    public void enqueue(E x) {
        elems[rear++] = x;
        if (rear == elems.length)
            rear = 0;
        length++;
    }

    public E dequeue() {
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)
                front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

class ArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        return (depth == 0);
    }

    public E peek() {
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        for (int i = 0; i < depth; i++)
            elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        elems[depth++] = x;
    }

    public E pop() {
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }

    public int len() {
        return elems.length;
    }
}