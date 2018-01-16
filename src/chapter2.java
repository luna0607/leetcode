import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ariana on 2018/1/10.
 */
public class chapter2 {
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
        chapter2 chapter2 = new chapter2();
//
//        /** 斐波那契数
//         * 给定 1，返回 0
//         * 给定 2，返回 1
//         * 给定 10，返回 34
//         */
//        for (int i = 1; i < 10; i++) {
//            System.out.println(chapter2.getFibonacci(i));
//        }
//
//        /** 单例
//         * A a = A.getInstance();
//         * A b = A.getInstance();
//         *  a应该等于b
//         */
//        chapter2 a=chapter2.getInstance();
//        chapter2 b=chapter2.getInstance();
//        System.out.println(a==b);
//
//        /**
//         * 空格替换
//         */
//        char[] tmp="hello world".toCharArray();
//        System.out.println(chapter2.replaceBlank(tmp,11));
//
//        /**
//         * 二进制中有多少个1
//         */
//        chapter2.countOnes(32);


//        /**
//         * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
//         */
//        ListNode head=new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(4);
//
//       ListNode list2=chapter2.reverse(null);
//           System.out.println("list2");
//            while (list2!=null){
//            System.out.println(list2.val);
//            list2=list2.next;
//        }
//        /**
//         * 用前序遍历和中序遍历获得二叉树
//         */
//        int[] pre = {1, 2, 4, 5, 3, 6,7};
//        int[] in = {4,2,5,1,6,3,7};
//        TreeNode root = chapter2.buildTree(pre, in);
//        System.out.print(root.val);
//        /**
//         * 搜索矩阵
//         */
//        int[][] matrix={
//                {1, 3, 5, 7},
//                {2, 4, 7, 8},
//                {3, 5, 9, 10}
//        };
//        System.out.print(chapter2.searchMatrix(matrix,3));

//        /**
//         * 分割一个整数数组，使得奇数在前偶数在后。
//         */
//        int[] array={2147483644,2147483645,2147483646,2147483647};
//        chapter2.partitionArray(array);

//        /**
//         * 测试子树
//         */
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(3);
//        chapter2.midOrder(treeNode);
//        System.out.println(chapter2.isSubtree(treeNode, null));
//        ListNode root=new ListNode(1);
//        root.next=new ListNode(2);
//        chapter2.removeNthFromEnd(root,2);

        /**
         * 测试合并链表
         */
        ListNode root = new ListNode(3);
        root.next = new ListNode(3);
        root.next.next = new ListNode(8);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(12);
        root2.next.next.next = new ListNode(13);

        ListNode newRoot=chapter2.mergeTwoLists(root, root2);
        while (newRoot!=null){
            System.out.println(newRoot.val);
            newRoot=newRoot.next;
        }
    }

    /**
     * 获得第n个斐波那契数列的数字
     *
     * @param n 第n个
     * @return 第n个数字
     */
    private int getFibonacci(int n) {
        int start = 0;
        int start2 = 1;
        int node = 0;
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        for (int i = 2; i < n; i++) {
            node = start + start2;
            start = start2;
            start2 = node;
        }
        return node;
    }

    /**
     * *设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例
     *
     * @return chapter2实例
     */
    public static chapter2 chapter2 = new chapter2();

    public static chapter2 getInstance() {
        // write your code here
        return chapter2;
    }

    /**
     * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
     * 你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
     * 你的程序还需要返回被替换后的字符串的长度。
     * @param string 已知字符串，例如“Mr John Smith“
     * @param length 已知长度，例如13
     * @return 替换后的字符串（"Mr%20John%20Smith"）的长度
     */
    public int replaceBlank(char[] string, int length) {
        char[] string2=string;
        int count=0;
        for(char tmp:string2){
            if(' ' == tmp){
                count++;
            }
        }
        string= Arrays.copyOf(string,string.length+count*2);
        int j=0;
        for(int i=0; i<string2.length; i++){
            if(string2[i]==' '){
                string[j]='%';
                j++;
                string[j]='2';
                j++;
                string[j]='0';
            }else {
                string[j]=string2[i];
            }
            j++;
        }
        System.out.println(string);
        return string.length;
    }

    /**
     * 计算在一个 32 位的整数的二进制表示中有多少个 1.
     * @param num 例如给定 32 (100000）
     * @return 返回1
     */
    public int countOnes(int num) {
        String binString=Integer.toBinaryString(num);
        int count=0;
        for(char tmp:binString.toCharArray()){
            if(tmp=='1'){
                count++;
            }
        }
        return count;
    }


    /**
     * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
     * 一开始没考虑到head是null,总是报错
     * @param head 头节点
     * @return 新的头节点
     */
    public ListNode reverse(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode list1=head;//原版list
        list1.next=head.next;
        ListNode list2=new ListNode(head.val);
        ListNode tmp;
        while (list1.next!=null){
            tmp=new ListNode(list1.next.val);
            tmp.next=list2;
            list2=tmp;
            list1=list1.next;
        }

        return list2;
    }

    /**
     * 找到数组里最小的值
     * @param nums 数组，例如【1，2，3，4，5】
     * @return 最小的值，例如 1
     */
    public int findMin(int[] nums) {
        double min=Double.POSITIVE_INFINITY;
        for(int i:nums){
            if(i<min){
                min=i;
            }
        }
        return (int)min;
    }

    /**
     * 根据前序遍历和中序遍历构造二叉树，递归拆分。每个子树视作一棵新树。
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else {
            int rootNum = preorder[0];
            TreeNode root = new TreeNode(rootNum);
            if (preorder.length == 1) {
                return root;
            } else {
                int index = indexOf(inorder, rootNum);
                int[] inOrderLeft = new int[index];
                for (int i = 0; i < index; i++) {
                    inOrderLeft[i] = inorder[i];
                }
                int[] inOrderRight = new int[inorder.length - index - 1];
                for (int i = 0; i < inOrderRight.length; i++) {
                    inOrderRight[i] = inorder[index + i + 1];
                }
                int[] preOrderLeft = new int[inOrderLeft.length];
                for (int i = 1; i < inOrderLeft.length + 1; i++) {
                    preOrderLeft[i - 1] = preorder[i];
                }
                int[] preOrderRight = new int[inOrderRight.length];
                for (int i = 0; i < inOrderRight.length; i++) {
                    preOrderRight[i] = preorder[index + 1 + i];
                }
                root.left = buildTree(preOrderLeft, inOrderLeft);
                root.right = buildTree(preOrderRight, inOrderRight);
                return root;
//              printIntArray(inOrderLeft);
//              System.out.print("||");
//              printIntArray(inOrderRight);
//              System.out.println();
//              printIntArray(preOrderLeft);
//              System.out.print("||");
//              printIntArray(preOrderRight);
            }
        }
    }

    private int indexOf(int[] inorder, int rootNum) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootNum) {
                return i;
            }
        }
        return -1;
    }

    private void printIntArray(int[] array) {
        for (int tmp : array) {
            System.out.print(tmp + " ");
        }
    }

    /**
     * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
     * 这个矩阵具有以下特性：
     * 每行中的整数从左到右是排序的。
     * 每一列的整数从上到下是排序的。
     * 在每一行或每一列中没有重复的整数。
     *
     * tip:
     * matrix.length是宽
     * matrix[0].length是高
     *
     * @param matrix 例如，[
     *               [1, 3, 5, 7],
     *               [2, 4, 7, 8],
     *               [3, 5, 9, 10]
     *               ]
     * @param target 例如 3
     * @return 则 2
     */
    public int searchMatrix(int[][] matrix, int target) {
        int width=matrix.length;
        if(width==0){
            return 0;
        }
        int height=matrix[0].length;
        int count=0;
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                if(matrix[i][j]>target) {
                    break;
                }else if(matrix[i][j]==target){
                    count++;
                }
            }
        }
        return count;
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
}
