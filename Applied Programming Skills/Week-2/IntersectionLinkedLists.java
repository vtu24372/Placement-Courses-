class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class IntersectionLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        // your test code here
    }
}
