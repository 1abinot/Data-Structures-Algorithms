package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesUnsortedSLL {
    public static void removeDuplicates(SLL<Integer> list) {
        /*
        input:
        7
        12 11 12 21 41 43 21
        output:
        12 11 21 41 43
         */
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = list.getFirst();
        SLLNode<Integer> prev = null;

        while (tmp1 != null) {
            tmp2=tmp1.succ;
            prev=tmp1;
            while (tmp2 != null) {
                if (!tmp1.element.equals(tmp2.element)) {
                    prev=tmp2;
                    tmp2 = tmp2.succ;
                }else{
                    tmp2 = tmp2.succ;
                    prev.succ = tmp2;
                }
            }
            tmp1=tmp1.succ;
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
        System.out.println(sll);
        removeDuplicates(sll);
        System.out.println(sll);
    }
}
