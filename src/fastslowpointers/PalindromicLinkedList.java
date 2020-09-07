package fastslowpointers;

public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //找中点
        /**
         * slow 1+m
         * fast 1+2m
         * total 1+2m or 2m
         */
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;

        //反转后半段链表
        ListNode runner = middle;
        ListNode last = middle;
        while (runner != null) {
            ListNode next = runner.next;
            runner.next = last;
            last = runner;
            runner = next;
        }

        //判断是否为palindrome链表
        ListNode left = head, right = last, end = last;
        while (left != middle) {
            if (left.value == right.value) {
                left = left.next;
                right = right.next;
                continue;
            }
            //不是回文链表，需要还原链表
            recovery(middle, end);
            return false;
        }

        //反转并还原后半段链表
        recovery(middle, end);
        return true;
    }

    private static void recovery(ListNode head, ListNode end) {
        ListNode runner = end, last = null;
        while (runner != head) {
            ListNode next = runner.next;
            runner.next = last;
            last = runner;
            runner = next;
        }
    }

    public static void main(String[] args) {
        /*ListNode head = null, node = head;
        int[] listNum = {2, 4, 6, 4, 2};
        for (int n : listNum) {
            if (node == null) {
                node = new ListNode(n);
                head = node;
                continue;
            }
            node.next = new ListNode(n);
            node = node.next;
        }*/
        ListNode head = ListNode.getLinkedList(new int[]{2, 4, 6, 4, 2});
        ListNode.printList(head);
        System.out.println("is palindrome: " + isPalindrome(head));

        head = ListNode.getLinkedList(new int[]{2, 4, 6, 4, 2, 5});
        ListNode.printList(head);
        System.out.println("is palindrome: " + isPalindrome(head));

        head = ListNode.getLinkedList(new int[]{2, 4, 6, 8, 8, 6, 4, 2});
        ListNode.printList(head);
        System.out.println("is palindrome: " + isPalindrome(head));
    }
}
