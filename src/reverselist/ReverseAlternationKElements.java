package reverselist;

/**
 * 每隔一个区间反转一次列表
 */
public class ReverseAlternationKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode current = head, previous = null;
        boolean needReverse = true;
        while (true) {
            ListNode lastNodeOfPreviousPart = previous, firstNodeOfCurrentPart = current;
            int i = 0;
            for (i = 0; current != null && i < k; i++) {
                ListNode next = current.next;
                previous = current;
                current = next;
            }
            if (i < k) {
                needReverse = true;
            }
            if (needReverse) { //反转链表
                ListNode c = firstNodeOfCurrentPart, pre = current;
                while (c != current) {
                    ListNode next = c.next;
                    c.next = pre;
                    pre = c;
                    c = next;
                }
                if (lastNodeOfPreviousPart == null) {
                    head = pre;
                } else {
                    lastNodeOfPreviousPart.next = pre;
//                    System.out.println(lastNodeOfPreviousPart.value);
                }
                previous = firstNodeOfCurrentPart;
            }
            if (current == null) {
                break;
            }
            if (needReverse) {
                needReverse = false;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;

        head = ListNode.getLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        head = reverse(head, 8);
        ListNode.printList(head);
    }
}
