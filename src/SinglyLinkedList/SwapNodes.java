package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapNodes {
    public static void swapNodes(SLL<Integer> list, int x, int y) {
        /*

        input:
        6
        10 15 12 13 20 14
        12 20
        output:
        10 15 20 13 12 14

         */
        SLLNode<Integer> X = list.getFirst();
        SLLNode<Integer> Y = list.getFirst();
        SLLNode<Integer> prevX = null;
        SLLNode<Integer> prevY = null;
        while (X != null) {
            if (X.element.equals(x)) {
                break;
            }
            prevX = X;
            X = X.succ;
        }

        while (Y != null) {
            if (Y.element.equals(y)) {
                break;
            }
            prevY = Y;
            Y = Y.succ;
        }



        if (prevX != null)
            prevX.succ = Y;
        else
            list.setFirst(Y);

        if (prevY != null)
            prevY.succ = X;
        else
            list.setFirst(X);

        SLLNode<Integer> tmp = X.succ;
        X.succ = Y.succ;
        Y.succ = tmp;

    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> sll = new SLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String []pomNiza = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sll.insertLast(Integer.parseInt(pomNiza[i]));
        }
        String []node = br.readLine().split(" ");


        System.out.println(sll);
        swapNodes(sll, Integer.parseInt(node[0]), Integer.parseInt(node[1]));
        System.out.println(sll);
    }

}
