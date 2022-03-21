package CodeSignal;

public class RemoveKFromList {
    ListNode<Integer> solution(ListNode<Integer> l, int k) {
        ListNode<Integer> last = l;
        ListNode<Integer> current = last;
        while(current != null) {
            if (current.value != k) {
                current = current.next;
                last = last.next;
            } else {
                current = current.next;
                last.next = current;
                last = last.next;
            }
        }

        return l;
    }
}
