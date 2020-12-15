package reverselist;

/**
 * 反转列表
 */
public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList(new int[]{2, 4, 6, 8, 10});
        head = reverse(head);
        ListNode.printList(head);
    }
}
