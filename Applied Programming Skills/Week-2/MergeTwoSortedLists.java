
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), c = d;
        while (a != null && b != null) {
            if (a.val <= b.val) { c.next = a; a = a.next; }
            else { c.next = b; b = b.next; }
            c = c.next;
        }
        c.next = (a != null) ? a : b;
        return d.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode m = mergeTwoLists(a, b);
        while (m != null) {
            System.out.print(m.val + " ");
            m = m.next;
        }
    }
}
