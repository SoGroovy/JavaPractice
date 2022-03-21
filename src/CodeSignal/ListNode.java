package CodeSignal;

import java.util.ArrayList;
import java.util.List;

class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;

        boolean solution(ListNode<Integer> l) {
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            while(l != null) {
                l1.add(l.value);
                l = l.next;
            }
            for (int i = l1.size(); i >= 0; i--) {
                l2.add(l1.get(i));
            }

            if(!(l1.equals(l2))) {
                return false;
            }
            return true;
        }

        public static void main(String[] args) {

        }
    }