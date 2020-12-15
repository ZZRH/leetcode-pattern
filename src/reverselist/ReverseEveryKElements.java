package reverselist;

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode lastNodeBeforeCurrentSublist = null, current = head, previous = null, firstNodeOfCurrentSublist = null;
        int indexInSublist = 1;
        while (current != null) {
            if (indexInSublist == 1) {
                firstNodeOfCurrentSublist = current;
            }
            ListNode next = current.next;
            current.next = previous;
            if (indexInSublist == k) {
                if (lastNodeBeforeCurrentSublist == null) {
                    head = current;
                } else {
                    lastNodeBeforeCurrentSublist.next = current;
                }
                lastNodeBeforeCurrentSublist = firstNodeOfCurrentSublist;
            }
            previous = current;
            current = next;
            indexInSublist++;
            if (indexInSublist > k) {
                indexInSublist = indexInSublist-k;
            }
        }
        if (indexInSublist != 1) {
            if (lastNodeBeforeCurrentSublist == null) {
                head = previous;
            } else {
                lastNodeBeforeCurrentSublist.next = previous;
            }
            firstNodeOfCurrentSublist.next = current;
        } else {
            lastNodeBeforeCurrentSublist.next = current;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        head = reverse(head, 3);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        head = reverse(head, 3);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        head = reverse(head, 3);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1});
        head = reverse(head, 3);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2});
        head = reverse(head, 3);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3});
        head = reverse(head, 3);
        ListNode.printList(head);

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4});
        head = reverse(head, 3);
        ListNode.printList(head);
    }
}
