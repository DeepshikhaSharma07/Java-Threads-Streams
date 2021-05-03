package com.tts.praticeThread;
// extends method
class Task1 extends Thread {
    public void run(){

        System.out.println("\n Task1 started ");
            for(int i = 1; i<= 10; i++)
            System.out.println(i + "  " );

        System.out.println("\n Task1 completed ");

    }
}

// interface method for threads

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.print("\n Task2 started ");
        for(int i = 11; i<= 20; i++)
            System.out.println(i + "  " );

        System.out.println("\n Task2 completed ");


    }
}
public class ThreadBasicsRunner {

    public static void main(String[] args) throws InterruptedException {
        //task1 -prints 1-10

         Task1 task1 = new Task1();
         // Can set a priority between 1-10. 10 being high.
        // does not mean that the request will be executed
         task1.setPriority(10);
         task1.start();
         System.out.println("\n Task1 kicked off ");

         // wait for task1 to complete
          task1.join();



        //task2
        System.out.println("\n Task2 kicked off ");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();


        //task3
        System.out.println("\n Task3 kicked off ");
        System.out.println("\n Task3 Started ");
        for(int i = 21; i<= 30; i++)
            System.out.println(i + "  " );

        System.out.println("\n Task3 completed ");

        System.out.println("\n Main Method completed ");
    }
}
