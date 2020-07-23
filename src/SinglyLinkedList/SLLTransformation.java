package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLLTransformation {
    //insert before a given number only the numbers that are smaller then the given number.
    public static void listTransformation(SLL<Integer> lista,int X)
    {
        //SEPTEMVRISKA LISTA - 2019
        /*
        input:
        6
        1 2 5 3 0 7
        5
        output:
        1 2 3 0 5 7
         */

        SLLNode<Integer> curr = lista.getFirst();

        while (curr != null && curr.element != X) {
            curr=curr.succ;
        }
        System.out.println(curr.element);

        SLLNode<Integer> tmp = curr;
        while (tmp != null) {
            if (tmp.element < X) {
                lista.insertBefore(tmp.element,curr);
                lista.delete(tmp);
            }
            tmp=tmp.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> sll = new SLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String []pomNiza = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sll.insertLast(Integer.parseInt(pomNiza[i]));
        }
        int x = Integer.parseInt(br.readLine());
        listTransformation(sll, x);
        System.out.println(sll);

    }
}
