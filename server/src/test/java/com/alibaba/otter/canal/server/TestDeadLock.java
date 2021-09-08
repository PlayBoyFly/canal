package com.alibaba.otter.canal.server;

import java.util.Random;

public class TestDeadLock {

   private static A a = new A();

   private static B b = new B();

   public static void main(String[]args){
      for(int i = 0 ; i < 200 ; i++){
         Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               execute();
            }
         });
         thread.start();;
      }

      try {
         Thread.sleep(1000000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static  void execute(){
      boolean randomBool = new Random().nextBoolean();
      if(randomBool){
         synchronized (a){
            System.out.println("lock a" + Thread.currentThread().getName());

            synchronized (b){
               System.out.println("lock b" + Thread.currentThread().getName());
            }
         }
      }else{
         synchronized (b){
            System.out.println("lock bV2" + Thread.currentThread().getName());

            synchronized (a){
               System.out.println("lock aV2" + Thread.currentThread().getName());
            }
         }
      }
   }

   /**
    * A类
    */
   public static class  A {
      private  int a;

   }

   public static  class B{
      private  int b;
   }
}
