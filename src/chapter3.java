import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Ariana on 2018/1/16.
 */
public class chapter3
{
    public static class ListNode {
        int val;
       ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static ArrayList<Integer> tmpOrder = new ArrayList<>();

    public static void main(String[] args) {
        chapter3 chapter3=new chapter3();
//        /**
//         * 分割一个整数数组，使得奇数在前偶数在后。
//         */
//        int[] array={2147483644,2147483645,2147483646,2147483647};
//        partitionArray(array);

//        /**
//         * 测试子树
//         */
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(3);
//        midOrder(treeNode);
//        System.out.println(isSubtree(treeNode, null));
//        ListNode root=new ListNode(1);
//        root.next=new ListNode(2);
//        removeNthFromEnd(root,2);

//        /**
//         * 测试合并链表
//         */
//        ListNode root = new ListNode(3);
//        root.next = new ListNode(3);
//        root.next.next = new ListNode(8);
//        ListNode root2 = new ListNode(1);
//        root2.next = new ListNode(2);
//        root2.next.next = new ListNode(12);
//        root2.next.next.next = new ListNode(13);
//
//        ListNode newRoot=mergeTwoLists(root, root2);
//        while (newRoot!=null){
//            System.out.println(newRoot.val);
//            newRoot=newRoot.next;
//        }
         System.out.println(chapter3.fastPower(109,10000007,1000001));
    }
        /**
     * 分割一个整数数组，使得奇数在前偶数在后。
     * 给定 [1, 2, 3, 4]，返回 [1, 3, 2, 4]。
     * @param nums 例如，[1, 2, 3, 4]
     */
    public void partitionArray(int[] nums) {
        int j=nums.length-1;
        for(int i=0; i<j; i++){
            if(nums[i]%2==0){
                while (nums[j]%2==0){
                    j--;
                }
                if(i<j){
                    int tmp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=tmp;
                }
            }
        }
        for(int n:nums){
            System.out.println(n);
        }
    }

    /**
     * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。
     * 请在在O(1)时间复杂度删除该链表节点。
     * @param node Linked list is 1->2->3->4, and given node 3, delete the node in place 1->2->4
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    /**
     * 有两个不同大小的二叉树：
     * T1 有上百万的节点； T2 有好几百的节点。
     * 请设计一种算法，判定 T2 是否为 T1的子树。
     *
     * @param T1 大树
     * @param T2 小树
     * @return 是/否
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        String preOrderT1String = "";
        String midOrderT1String = "";
        String preOrderT2String = "";
        String midOrderT2String = "";


        tmpOrder = new ArrayList<>();
        preOrder(T1);
        if (tmpOrder.size() != 0) {
            ArrayList<Integer> preOderT1 = tmpOrder;
            preOrderT1String = preOderT1.toString();
            preOrderT1String = preOrderT1String.substring(1, preOrderT1String.length() - 1);
        }

        tmpOrder = new ArrayList<>();
        midOrder(T1);
        if (tmpOrder.size() != 0) {
            ArrayList<Integer> minOrderT1 = tmpOrder;
            midOrderT1String = minOrderT1.toString();
            midOrderT1String = midOrderT1String.substring(1, midOrderT1String.length() - 1);
        }


        tmpOrder = new ArrayList<>();
        preOrder(T2);
        if (tmpOrder.size() != 0) {
            ArrayList<Integer> preOrderT2 = tmpOrder;
            preOrderT2String = preOrderT2.toString();
            preOrderT2String = preOrderT2String.substring(1, preOrderT2String.length() - 1);
        }

        tmpOrder = new ArrayList<>();
        midOrder(T2);
        if (tmpOrder.size() != 0) {
            ArrayList<Integer> midOrderT2 = tmpOrder;
            midOrderT2String = midOrderT2.toString();
            midOrderT2String = midOrderT2String.substring(1, midOrderT2String.length() - 1);
        }

        return preOrderT1String.contains(preOrderT2String) && midOrderT1String.contains(midOrderT2String);
    }

    /**
     * 前序遍历，返回值在tmpOrder里
     * @param treeNode 根节点
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            tmpOrder.add(treeNode.val);
            if (treeNode.left != null) {
                preOrder(treeNode.left);
            }else {
                tmpOrder.add(-1);
            }
            if (treeNode.right != null) {
                preOrder(treeNode.right);
            }else {
                tmpOrder.add(-1);
            }
        }
    }

    /**
     * 中序遍历，返回值在tmpOrder里
     * @param treeNode 根节点
     */
    public void midOrder(TreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.left != null) {
                midOrder(treeNode.left);
            }else {
                tmpOrder.add(-1);
            }
            tmpOrder.add(treeNode.val);
            if (treeNode.right != null) {
                midOrder(treeNode.right);
            }else {
                tmpOrder.add(-1);
            }
        }
    }

    /**
     *给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
     * @param head 头节点
     * @param n 倒数第N个
     * @return 头节点
     */
     public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
         ListNode tmpN=new ListNode(head.val);
         tmpN.next=head.next;
         ListNode HEAD=new ListNode(head.val);
         HEAD.next=head.next;

         int count=0;
         while (head.next!=null){
             if(count<n){
                 count++;
             }else {
                 tmpN=tmpN.next;
             }
             head=head.next;
         }
         if(count==0){//整个链表就是一个空表
             return null;
         }else if(n-count==1){//删除的是头
             tmpN=tmpN.next;
             return tmpN;
         } else {
             if(tmpN.next.next!=null){
                 tmpN.next=tmpN.next.next;
             }else {//删除的是尾
                 tmpN.next=null;
             }
             return HEAD;
         }
    }

    /**
     * 将两个排序链表合并为一个新的排序链表
     *
     * @param l1 链表1，例如 1->3->8->11->15->null
     * @param l2 链表2，例如 2->null
     * @return 新排序链表，1->2->3->8->11->15->null
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode ptr1 = l1;
            ListNode ptr2 = l2;
            ListNode HEAD = new ListNode(l1.val);
            HEAD.next = l1.next;
            int ptr1count=0;
            while (ptr1 != null && ptr2 != null && ptr1.val >= ptr2.val&&ptr1count==0) {
                ListNode tmpHead=new ListNode(ptr2.val);
                tmpHead.next=HEAD;
                HEAD=tmpHead;
                ptr1=HEAD;
                ptr2 = ptr2.next;
                ptr1count++;
            }
            while (ptr1 != null && ptr2 != null) {
                if (ptr1.val <= ptr2.val && (ptr1.next == null || ptr1.next.val >= ptr2.val)) {
                    ListNode tmp = new ListNode(ptr2.val);
                    tmp.next = ptr1.next;
                    ptr1.next = tmp;
                    ptr2 = ptr2.next;
                }
                if(ptr1count==0){
                    HEAD=new ListNode(ptr1.val);
                    HEAD.next=ptr1.next;
                }
                ptr1 = ptr1.next;
                ptr1count++;
            }
            return HEAD;
        }
    }


    /**
     * 用递归打印数字
     * @param n N位数
     * @return 从1 到最大的N位数，例如N=2，则返回【1，2，3，4...，99】
     */
      public ArrayList<Integer> numbersByRecursion(int n) {
          if(n==0){
              return new ArrayList<Integer>();
          }
          if(n==1){
              ArrayList<Integer> result=new ArrayList<>();
              for(int i=1;i<10;i++){
                  result.add(i);
              }
              return result;
          }else {
              ArrayList<Integer> result=numbersByRecursion(n-1);
              for(int i=(int)Math.pow(10,n-1);i<Math.pow(10,n);i++){
                  result.add(i);
              }
              return result;
          }
    }

    /**
     * 快速幂a的n次方 % b
     * @param a 底数
     * @param b 指数
     * @param n 除数
     * @return 余数
     */
     public int fastPower(int a, int b, int n) {
         BigInteger tmp=new BigInteger(Integer.toString(a%b));
         BigInteger single=tmp;
         BigInteger B=new BigInteger(Integer.toString(b));
         if(n%2==1){
             tmp=new BigInteger("1");
         }
         if(n==0||a==1){
             return a%b;
         }
         while (n!=0){
             if(n%2==0){
                 tmp=tmp.multiply(tmp);
                 if(tmp.compareTo(B)==1){
                     tmp=tmp.divideAndRemainder(B)[1];
                 }
                 n=n/2;
             }else {
                 tmp=tmp.multiply(single);
                 n--;
             }
         }
            if(tmp.compareTo(B)==1){
                     tmp=tmp.divideAndRemainder(B)[1];
                 }
         return Integer.parseInt(tmp.toString());
    }
}
