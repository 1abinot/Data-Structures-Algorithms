package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Swap Kth node from beginning with Kth node from end in a Doubly Linked List
*/
public class SwapNodes {
    /*
    Input:
    5
    1 2 3 4 5
    K:
    1

    Output:
    1 4 3 2 5



    Input:
    6
    1 2 3 4 5 6
    K:2

    Output:
    1 2 4 3 5 6


    Input:
    5
    1 2 3 4 5
    K:
    2

    Output:
    1 2 3 4 5
    */
    public static void swapKth(DLL<Integer> list, int k) {
        DLLNode<Integer> curr1 = list.getFirst();
        DLLNode<Integer> curr2 = list.getLast();
        int counter=0;
        while(curr1!=null && curr2!=null) {
            if(counter==k && curr1!=curr2) {
                list.insertBefore(curr2.element, curr1);
                list.insertBefore(curr1.element,curr2);
                list.delete(curr1);
                list.delete(curr2);
            }
            curr1=curr1.succ;
            curr2=curr2.pred;
            counter++;
        }
    }
    public static void main(String[] args) throws IOException {
        DLL<Integer> dll = new DLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String []pomNiza = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            dll.insertLast(Integer.parseInt(pomNiza[i]));
        }
        System.out.println("K: ");
        int k = Integer.parseInt(br.readLine());


        System.out.println(dll);

        swapKth(dll, k);
        System.out.println(dll);
    }
}
