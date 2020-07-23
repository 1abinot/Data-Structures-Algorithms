package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesSortedSLL {
    public static void removeDuplicates(SLL<Integer> list) {
        /*
        input:
        7
        11 11 11 21 43 43 60

        output:
        11 21 43 60
         */
        SLLNode<Integer> tmp = list.getFirst();

        while (tmp.succ != null) {
            if (tmp.element.equals(tmp.succ.element)) {
                tmp.succ = tmp.succ.succ;
            }else{
                tmp = tmp.succ;
            }
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
