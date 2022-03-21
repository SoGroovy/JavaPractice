package LeetCode.Easy;

import java.util.List;

public class ListNode {

    int val;
    ListNode next;


    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode current = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            } else {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }
        if (list1 != null) {
            current.next = list1;
            list1 = list1.next;
        } else if (list2 != null) {
            current.next = list2;
            list2 = list2.next;
        }

        return mergedList.next;
    }

    public ListNode combineTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = list1;
        ListNode current = list3;
        while (current.next != null) {
            current = list1.next;
        }
        if (current.next == null) {
            current.next = list2;
        }
        return list3;
    }

    public ListNode mergeTwoListsAlt(ListNode list1, ListNode list2) {
        ListNode head = list1;
        ListNode last = head;
        while (list1 != null && list2 != null) {
            if (last == list1) {
                list1 = list1.next;
                last.next = list2;
                last = list2;
            } else {
                list2 = list2.next;
                last.next = list1;
                last = list1;
            }
        }
        if (list1 == null) {
            last.next = list2;
        }
        else {
            last.next = list1;
        }
        return head;
    }
}







