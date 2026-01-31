class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseList(head); // now 5 -> 4 -> 3 -> 2 -> 1

        // print reversed list
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
    }
}
