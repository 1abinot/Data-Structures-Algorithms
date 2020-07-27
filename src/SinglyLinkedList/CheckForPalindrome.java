package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static SinglyLinkedList.ReverseSLL.reverse;

public class CheckForPalindrome {
    public static boolean isPalindrome(SLL<Integer> list) {
        /*

        input:
        5
        1 2 3 2 1

        output:
        true

        input:
        5
        1 2 3 1 2

        output:
        false

         */
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = list.getFirst();

        SLLNode<Integer> start_second = null;
        SLLNode<Integer> first = list.getFirst();
        while (true) {
            tmp1 = tmp1.succ.succ;
            if (tmp1 == null) {
                start_second = tmp2.succ;
                break;
            }
            if (tmp1.succ == null) {
                start_second = tmp2.succ.succ;
                break;
            }
            tmp2=tmp2.succ;
        }
        tmp2.succ = null;
        list.setFirst(start_second);
        reverse(list);
        tmp1=list.getFirst();

        while (first != null && tmp1 != null) {
            if (!first.element.equals(tmp1.element)) {
                return false;
            }
            first=first.succ;
            tmp1=tmp1.succ;
        }
        return true;

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
        System.out.println(isPalindrome(sll));
    }
}
