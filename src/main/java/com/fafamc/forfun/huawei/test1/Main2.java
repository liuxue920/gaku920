package com.fafamc.forfun.huawei.test1;

public class Main2 {

    //定义结点，必须是static
    static class Node {
        int data;
        Node next;
        Node(int arg1)
        {
            this.data = arg1;
        }
    }
    public static void main(String[] args)
    {
        int n = 3,m = 100;//定义总人数n，和出圈数字m

        //初始化循环列表,头结点first和尾结点p
        Node first = new Node(1);
        first.next = first;
        Node p = first;
        for(int i=2; i<=n; i++)
        {
            Node temp = new Node(i);
            temp.next = p;
            p.next = temp;
            p = p.next;
        }
        p.next = first;//尾接头形成循环链表（p为尾结点）

        //执行出圈操作
        System.out.println("出圈顺序为:");
        while(p != p.next)
        {
            //下面for循环后，p是第m个结点的前一个结点
            for(int i=1; i<m; i++)
                p = p.next;
            //删除第m个结点
            System.out.print(p.next.data+" ");
            p.next = p.next.next;
        }
        System.out.println("\n幸运者是:"+p.data);
    }
}
