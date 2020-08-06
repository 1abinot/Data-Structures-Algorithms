package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapFirstAndLastNode {
    public static void swap(SLL<Integer> list) {
        SLLNode<Integer> fp = list.getFirst();
        SLLNode<Integer> lp = list.getFirst();
        SLLNode<Integer> plp = null;

        while (lp.succ != null) {
            plp = lp;
            lp = lp.succ;
        }

        plp.succ = fp;
        list.setFirst(lp);  //first = lp;
        lp.succ = fp.succ;
        fp.succ = null;

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
        swap(sll);
        System.out.println(sll);
        //System.out.println(sll);
    }
}
