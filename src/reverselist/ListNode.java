package reverselist;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("\b\b\b\b");
    }

    /**
     * 根据数组来返回链表
     * @param listNum
     * @return 链表的头节点
     */
    public static ListNode getLinkedList(int[] listNum) {
        ListNode head = null, node = head;
        for (int n : listNum) {
            if (node == null) {
                node = new ListNode(n);
                head = node;
                continue;
            }
            node.next = new ListNode(n);
            node = node.next;
        }
        return head;
    }
}