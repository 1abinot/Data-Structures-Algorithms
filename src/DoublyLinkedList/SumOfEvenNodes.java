package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfEvenNodes {
    public static void sumOfEvenNodes(DLL<Integer> lista) {
        /*
        Input:
        6
        1 2 3 4 5 6
        1<->2<->3<->4<->5<->6   -> 1 + 3 + 5 = 9

        Output:
        9<->2<->9<->4<->9<->6

        */
        int sum=0;
        int counter=0;
        DLLNode<Integer> curr = lista.getFirst();
        while(curr!=null) {
            if(counter%2==0) {
                sum+=curr.element;
            }
            curr=curr.succ;
            counter++;
        }
        curr=lista.getFirst();
        counter=0;
        DLLNode<Integer> tmp;
        while(curr!=null) {
            if(counter%2==0) {
                lista.insertBefore(sum, curr);
                lista.delete(curr);
            }
            curr=curr.succ;
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
        System.out.println(dll);
        sumOfEvenNodes(dll);
        System.out.println(dll);
    }
}
