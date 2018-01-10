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
    public class TreeNode {
     public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }


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
           for(int i=0;i<string2.length;i++){
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
     * 根据前序遍历和中序遍历构造二叉树
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return 二叉树根节点
     */
      public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
          return null;
    }
}
