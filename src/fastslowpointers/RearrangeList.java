package fastslowpointers;

public class RearrangeList {
    public static void reorder(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode originalEndNode = reverse(slow.next);
        ListNode rightRunner = originalEndNode, leftRunner = head;
        slow.next = null;

        //2 4 6 8
        //12 10
        while (rightRunner != null) {
            ListNode leftNext = leftRunner.next;
            ListNode rightNext = rightRunner.next;
            leftRunner.next = rightRunner;
            rightRunner.next = leftNext;
            leftRunner = leftNext;
            rightRunner = rightNext;
        }

    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList(new int[]{2, 4, 6, 8, 10, 12});
        reorder(head);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{2, 4, 6, 8, 10});
        reorder(head);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1,2,3});
        reorder(head);
        ListNode.printList(head);
    }
}
