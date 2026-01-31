class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MiddleOfTheList {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step
            fast = fast.next.next;   // 2 steps
        }
        return slow;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Example 1: [1,2,3,4,5]
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next = new ListNode(5);

        System.out.print("Original 1: ");
        printList(h1);
        ListNode mid1 = middleNode(h1);
        System.out.print("Middle 1:   ");
        printList(mid1);   // 3 -> 4 -> 5

        // Example 2: [1,2,3,4,5,6]
        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = new ListNode(3);
        h2.next.next.next = new ListNode(4);
        h2.next.next.next.next = new ListNode(5);
        h2.next.next.next.next.next = new ListNode(6);

        System.out.print("Original 2: ");
        printList(h2);
        ListNode mid2 = middleNode(h2);
        System.out.print("Middle 2:   ");
        printList(mid2);   // 4 -> 5 -> 6
    }
}
