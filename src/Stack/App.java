package Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
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

    // Stekot e pretstaven na sledniot nacin:
    //depth e dlabochinata na stekot, a
    // elems[0...depth-1] se negovite elementi.
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

    public int length() {
        return elems.length;
    }
}

public class App {
    public static int postfixEvaluation(String exp) {

        ArrayStack<Integer> stack = new ArrayStack<Integer>(exp.length());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                if (Character.isDigit(exp.charAt(i + 1))) {
                    sb.append(exp.charAt(i));
                }else{
                    sb.append(exp.charAt(i));
                    stack.push(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
            } else if (exp.charAt(i) == '+') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 + op1);
            } else if (exp.charAt(i) == '-') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            } else if (exp.charAt(i) == '*') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 * op1);
            } else if (exp.charAt(i) == '/') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            } else if (exp.charAt(i) == '^') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push((int)Math.pow(op2, op1));
            }else{
                System.out.println("Invalid expression");
                return 0;
            }

        }
        return stack.pop();
    }



    public static int proveri_t_posle_s(char [] St) {
        ArrayStack<Character> stack = new ArrayStack<Character>(St.length);

        for (int i = 0; i < St.length;i++) {
            if (St[i] == 'S' || St[i] == 'T') {
                stack.push(St[i]);
            }
        }

        int countT = 0;
        int countAfter = 0;
        boolean sFirst = true;
        int br = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == 'S') {
                if (sFirst) {
                    return 0;
                }
                if (br%2==0 && countT!=0) {
                    countAfter = countT;
                }

                if(br%2!=0)
                    countAfter-=countT;

                if (countAfter < 0) {
                    return 0;
                }
                br+=1;
                countT=0;
            } else if (c == 'T') {
                countT++;
                sFirst=false;
            }
        }


        if(countAfter == 0 )
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println(postfixEvaluation(br.readLine()));
        //System.out.println(infixEval(br.readLine()));

        char [] niza=new char[100];

        Scanner f=new Scanner(System.in);
        String st=f.next();
        niza=st.toCharArray();

        int rez= proveri_t_posle_s(niza);
        System.out.println(rez);
    }
}
