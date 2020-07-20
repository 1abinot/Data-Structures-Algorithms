package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

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


class LinkedStack<E> implements Stack<E> {

    //Stekot e pretstaven na sledniot nacin: top e link do prviot jazol
    // na ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
    private SLLNode<E> top;

    public LinkedStack () {
        // Konstrukcija na nov, prazen stek.
        top = null;
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }

    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void clear () {
        // Go prazni stekot.
        top = null;
    }

    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        top = new SLLNode<E>(x, top);
    }

    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        top = top.succ;
        return topElem;
    }

    public int size() {
        SLLNode<E> tmp = top;
        int length=0;
        while (tmp != null) {
            length++;
            tmp=tmp.succ;
        }
        return length;
    }

}

public class LinkedStackApp {
    public static int checkXML(String[] xml) {
        LinkedStack<String> stack = new LinkedStack<String>();

        for (String s : xml) {
            if (s.charAt(0) == '[') {
                if (s.charAt(1) != '/') {
                    stack.push(s.substring(1));
                } else {
                    if (stack.isEmpty()) {
                        return 0;
                    }
                    if (!stack.pop().equals(s.substring(2))) {

                        return 0;
                    }
                }
            }
        }

        if (stack.isEmpty())
            return 1;

        return 0;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }else{
                while (true) {
                    int peek = stack.peek();
                    if (peek < 0) {
                        stack.push(asteroids[i]);
                        break;
                    } else if (peek == -asteroids[i]) {
                        stack.pop();
                        break;
                    } else if (peek > -asteroids[i]) {
                        break;
                    }else{
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] output = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }
        return output;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());




        /*
        Valid XML
        String[] xmlCode = new String[n];
        for (int i = 0; i < n; i++) {
            xmlCode[i] = br.readLine();
        }

        System.out.println(checkXML(xmlCode));
        */

       int[] asteroids = new int[n];
        String []line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            asteroids[i] = Integer.parseInt(line[i]);
        }

        asteroids = asteroidCollision(asteroids);

        for (int i = 0; i < asteroids.length; i++) {
            System.out.println(asteroids[i]);
        }

    }
}
