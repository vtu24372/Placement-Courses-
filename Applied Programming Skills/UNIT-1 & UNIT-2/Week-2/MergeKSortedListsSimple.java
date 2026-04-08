import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedListsSimple {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        List<Integer> vals = new ArrayList<>();
        for (ListNode head : lists) {
            while (head != null) {
                vals.add(head.val);
                head = head.next;
            }
        }

        if (vals.isEmpty()) return null;

        Collections.sort(vals);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // list1: 1 -> 4 -> 5
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        // list2: 1 -> 3 -> 4
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        // list3: 2 -> 6
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] lists = {a, b, c};
        ListNode head = mergeKLists(lists);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        // output: 1 1 2 3 4 4 5 6
    }
}
