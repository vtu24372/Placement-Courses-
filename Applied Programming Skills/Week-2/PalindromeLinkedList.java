public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        // compare halves
        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    // quick test
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(a)); // true

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        System.out.println(isPalindrome(b)); // false
    }
}
