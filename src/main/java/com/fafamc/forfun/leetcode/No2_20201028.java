//package com.fafamc.forfun.leetcode;
//
///**
// * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
// * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
// * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
// *
// * 示例：
// * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
// * 输出：7 -> 0 -> 8d
// * 原因：342 + 465 = 807
// *
// */
//public class No2_20201028 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int deep1 = getDeep(l1);
//        int deep2 = getDeep(l2);
//        if(deep1 > deep2 ){
//            l2 = fullZero(l2,deep1-deep2);
//        }
//        if(deep1 < deep2 ){
//            l1 = fullZero(l1,deep2-deep1);
//        }
//        ListNode returnNode=new ListNode();
//        ListNode flag=returnNode.next;
//        int nextVal = 0;
//        // 2 4 1   142
//        // 5 6 4   465
//        // 7 0 6   607
//        while(l1 != null && l2 != null){
//            int val1 = l1.val;
//            int val2 = l2.val;
//
//            int thisVal = (val1+val2+nextVal)%10;
//            nextVal = (val1+val2+nextVal)/10;
//
////            returnNode.next=new ListNode(thisVal);
////            returnNode =  returnNode.next;
//
//            while(flag != null ){
//                flag = flag.next;
//            }
//            flag =new ListNode(thisVal);
//
//
//            l1 = l1.next;
//            l2 = l2.next;
//
//        }
//        if(nextVal != 0){
//            returnNode.next = new ListNode(nextVal);
//        }
//        return returnNode;
//    }
//
//    // 得到数字的深度，位数
//    public int getDeep(ListNode l){
//        int deep = 1;
//        ListNode next = l.next;
//        while(next != null){
//            next = next.next;
//            deep ++;
//        }
//        return deep;
//    }
//
//    // 补零
//    public ListNode fullZero(ListNode l,int num){
//        for(int i = 0 ; i<num; i++){
//            l.next = new ListNode(0);
//            l = l.next;
//        }
//        return l;
//    }
//
//
//    public static void main(String[] args) {
////        ListNode first = new ListNode(2,new ListNode(4,new ListNode(1)));
////        ListNode second = new ListNode(5,new ListNode(6,new ListNode(4)));
////        No2_20201028 obj = new No2_20201028();
////        System.out.println(obj.addTwoNumbers(first,second));
//
//
//        ListNode first1 = new ListNode(9);
//        ListNode second1 = new ListNode(9,new ListNode(1,new ListNode(1)));
//        No2_20201028 obj2 = new No2_20201028();
//        System.out.println(obj2.addTwoNumbers(first1,second1));
//    }
//
//
//
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//
//        @Override
//        public String toString() {
//            if(next != null){
//                return val +"->"+ next.toString();
//            }
//            return val +"";
//        }
//    }
//}
