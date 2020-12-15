package reverselist;

public class ReverseSublist {
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q || head == null) {
            return head;
        }
        if (p > q) {
            int temp = p;
            p = q;
            q = temp;
        }

        ListNode current = head, previous = null;
        for (int i = 1; i <= p-1; i++) {
            if (current == null) {
                System.out.println("exception: p > head.length");
                return head;
            }
            previous = current;
            current = current.next;
        }
        // 此时current为sublist的第一个node
        ListNode nodeBeforeSublist = previous, firstNodeOfSublist = current;
        for (int i = 1; current != null && i <= q - p + 1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        //此时current为sublist后的第一个node
        if (nodeBeforeSublist != null) {
            nodeBeforeSublist.next = previous;
        } else {
            head = previous;
        }
        if (firstNodeOfSublist != null) {
            firstNodeOfSublist.next = current;
        } else {
            nodeBeforeSublist.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5});
        head = reverse(head, 2, 4);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5});
        head = reverse(head, 1, 4);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5});
        head = reverse(head, 2, 5);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5});
        head = reverse(head, 6, 10);
        ListNode.printList(head);
    }
}
