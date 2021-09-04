package com.alibaba.otter.canal.server;

import org.junit.Test;

public class LinkTest {


    public static void main(String[]args){
        ListNode head = new ListNode(1 , null);
        ListNode cur = head;
        for(int i =2 ; i < 6; i++){
            cur.setNext(new ListNode(1 , null));
        }

    }

    public static class ListNode{
       public int val;
       public ListNode next = null;
       public ListNode(int val , ListNode next){
           this.val = val;
           this.next = next;
       }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        //1、找到位置
        ListNode nodeMPre = null;
        ListNode nodeM = null;
        ListNode nodeN = null;
        ListNode nodeNNext = null;
        int i = 1 ;
        ListNode cur = head;
        while(cur!= null){
            if(i == m -1){
                nodeMPre = cur;
            }
            if(i == m){
                nodeM = cur;
            }
            if(i == n){
                nodeN = cur;
            }

            if(i == n+1){
                nodeNNext = cur.next;
            }

            cur = cur.next;
            i++;
        }

        System.out.println(nodeM.val  + "----" + nodeN.val + "----" + nodeMPre.val + "----" + nodeNNext.val);
        //2、反转单链表
        reverseSingleList(nodeM , nodeN);

        //3、移动指针
        nodeMPre.next = nodeN;
        nodeM.next = nodeNNext;

        if (m == 1) {
            return nodeN;
        } else {
            return head;
        }
    }

    /**
     *  反转单链表
     **/
    public void reverseSingleList(ListNode nodeM , ListNode nodeN){
        ListNode pre = null;
        ListNode cur = nodeM;

        while(cur.next != null){
            ListNode  next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if(cur == nodeN){
                break;
            }
        }

    }
}
