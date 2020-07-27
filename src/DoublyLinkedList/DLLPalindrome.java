package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLPalindrome {
    public static int palindrome(DLL<Integer> lista){
        /*
        Input:
        5
        1 2 3 1 2
        Output:
        -1

        7
        5 4 8 9 8 4 5
        Output:
        1
        */
        DLLNode<Integer> tmp1 = lista.getFirst();
        DLLNode<Integer> tmp2 = lista.getLast();

        while (tmp1 != tmp2) {
            if (!tmp1.element.equals(tmp2.element)) {
                return -1;
            }
            tmp1 = tmp1.succ;
            tmp2 = tmp2.pred;
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DLL<Integer> dll = new DLL<>();
        int n = Integer.parseInt(br.readLine());

        String []niza = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            dll.insertLast(Integer.parseInt(niza[i]));
        }

        System.out.println(palindrome(dll));
    }
}
