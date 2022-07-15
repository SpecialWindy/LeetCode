/**
 * Definition for singly-linked list
 * public class ListNode{
 *     int val;
 *     ListNode next;
 *     ListNode(){}
 *     ListNode(int val) {this.val = val}
 *     ListNode(int val, ListNode next){this.val = val; this.next = next}
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}  //无参构造
    ListNode(int val) { this.val = val;} //有参构造
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class LinkList {

    /**
     * 定义全局静态变量，方便操作
     */
    public static ListNode head = new ListNode();

    /**
     * 主函数 - 方法功能测试
     * @param args
     */
    public static void main(String[] args) {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        addNode(6);
        addNode(8);
        addNode(9);
        traverse(head);
        removeNthFromEnd(head,3);
        traverse(head);
        int midNode = searchMid(head.next);
        System.out.println(midNode);

        ListNode newHead = new ListNode();

        //头结点数据默认为0，实际不考虑
        newHead.next = reverseList(head.next);

        traverse(newHead);
    }

    /**
     * 增加结点构造链表，使用尾插法
     * @param val
     * @return void
     */
    public static void addNode(int val) {

        ListNode newNode = new ListNode(val);

        ListNode tmpNode = head;

        while(tmpNode.next != null) {
            tmpNode = tmpNode.next;
        }

        tmpNode.next = newNode;
    }

    /**
     * 遍历链表
     * @param head
     */
    public static void traverse(ListNode head) {
        ListNode tmpNode = head;
        while(tmpNode.next != null) {
            if (tmpNode.next.next == null) {
                System.out.println(tmpNode.next.val);
                break;
            }
            System.out.print(tmpNode.next.val + "->");
            tmpNode = tmpNode.next;
        }

    }

    /**
     * 删除链表倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public static void removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        //创建虚拟头结点,指向头结点
        dummyNode.next = head;

        ListNode q = dummyNode;
        ListNode p = head;
        //快指针先走n步
        while(n-- > 0) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        System.out.println("倒数第n结点已删除");
    }

    /**
     * 反转链表 - 使用迭代法
     * @param head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 在某个位置插入结点
     * @param head
     * @param index
     * @param val
     */
    public static void insertNode(ListNode head, int index, int val) {

    }

    /**
     * 查找链表中间结点
     * @param head
     * @return
     */
    public static int searchMid(ListNode head) {
        ListNode p = head;
        ListNode q = head;

        while(q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p.val;
    }
}
