package CodeSignal;

import java.util.List;

public class AddTwoHugeNumbers {
    public static void main(String[] args){
        ListNode<Integer> a = new ListNode<Integer>(0);
        ListNode<Integer> b = new ListNode<Integer>(0);
        ListNode<Integer> p = a;
        int[] arrayA = {9876, 5432, 1999};
        int[] arrayB = {1, 8001};
        //create list node A
        for (int i = 0; i < arrayA.length; i++) {
            p.next = new ListNode<Integer>(arrayA[i]);
            p = p.next;
        }
        a = a.next;
        p = b;
        //create list node B
        for (int i = 0; i < arrayB.length; i++) {
            p.next = new ListNode<Integer>(arrayB[i]);
            p = p.next;
        }
        b = b.next;

        ListNode<Integer> sum = solution(a, b);
        while (sum != null) {
            System.out.print(sum.value);
            sum = sum.next;
        }
    }

    public static ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> l1 = new ListNode<Integer>(null);
        ListNode<Integer> p = a;
        while (a != null) { //reversing the linked-list a
            a = a.next;
            p.next = l1;
            l1 = p;
            p = a;
        }

        ListNode<Integer> l2 = new ListNode<>(null);
        p = b;
        while (b != null) { //reversing linked list b
            b = b.next;
            p.next = l2;
            l2 = p;
            p = b;
        }

        ListNode<Integer> sum = new ListNode<>(null);
        p = sum;
        int carry = 0;
        while (l1 != null && l2 != null) {
           if (carry == 1) {
               p.next = new ListNode<>(l1.value + l2.value + 1);
           } else {
               p.next = new ListNode<>(l1.value + l2.value);
           }
           p = p.next;
           if (p.value > 9999) {
               carry = 1;
               p.value -= 10000;
           } else {
               carry = 0;
           }
           l1 = l1.next;
           l2 = l2.next;
        }
        sum = sum.next;
        ListNode<Integer> head = new ListNode<Integer>(0);
        p = head;
        while (sum != null) {
            sum = sum.next;
            p.next = head;
            head = p;
            p = sum;
        }
        return head.next;
    }


}
