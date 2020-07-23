package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseSLL {
    public static void reverse(SLL<Integer> list) {
        /*
        input:
        6
        1 2 3 4 5 6
        output:
        6 5 4 3 2 1
         */
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = list.getFirst();
        SLLNode<Integer> prev = null;

        while (tmp1 != null) {
            tmp1 = tmp1.succ;
            tmp2.succ = prev;
            prev = tmp2;
            tmp2 = tmp1;
        }
        list.setFirst(prev);

    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> sll = new SLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String []pomNiza = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sll.insertLast(Integer.parseInt(pomNiza[i]));
        }
        System.out.println(sll);
        reverse(sll);
        System.out.println(sll);
    }
}
