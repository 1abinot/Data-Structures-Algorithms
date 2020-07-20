package Queue;

import java.util.NoSuchElementException;

interface Queue<E>{
    public boolean isEmpty();

    public int size();

    public E peek();

    public void clear();

    public void enqueue(E x);

    public E dequeue();
}

class ArrayQueue<E> implements Queue<E> {
    E[] elems;
    int length, front, rear;

    public ArrayQueue(int maxLength) {
        elems = (E[]) new Object[maxLength];
        front = rear = length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public E peek() {
        if (length > 0) {
            return elems[front];
        } else
            throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        length = 0;
        front = rear = 0;
    }

    @Override
    public void enqueue(E x) {
        elems[rear++] = x;
        if (rear == elems.length)
            rear = 0;

        length++;
    }

    @Override
    public E dequeue() {
        if (length > 0) {
            E frontMost = elems[front];
            elems[front++] = null;

            if (front == elems.length)
                front = 0;

            length--;

            return frontMost;
        }
        else
            throw new NoSuchElementException();
    }
}

public class ArrayQueueApp {
    public static void main(String[] args) {

    }
}
