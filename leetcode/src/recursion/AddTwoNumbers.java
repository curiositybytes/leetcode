package recursion;

/**
 * 2. Add Two Numbers
 *
 * @link <a href="https://leetcode.com/problems/add-two-numbers/?envType=problem-list-v2&envId=recursion">...</a>
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(9, null);
        ListNode l12 = new ListNode(9, l11);
        ListNode l13 = new ListNode(9, l12);
        ListNode l14 = new ListNode(9, l13);
        ListNode l15 = new ListNode(9, l14);
        ListNode l16 = new ListNode(9, l15);
        ListNode l17 = new ListNode(9, l16);

        ListNode l21 = new ListNode(9, null);
        ListNode l22 = new ListNode(9, l21);
        ListNode l23 = new ListNode(9, l22);
        ListNode l24 = new ListNode(9, l23);

        ListNode result = addTwoNumbers(l17, l24);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private static ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = 0;

        if (l1 != null) {
            sum += l1.val;
        }

        if (l2 != null) {
            sum += l2.val;
        }

        if (carry != 0) {
            sum += carry;
        }

        carry = sum > 9 ? 1 : 0;
        sum = sum > 9 ? sum - 10 : sum;

        ListNode result = new ListNode(sum);
        result.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


