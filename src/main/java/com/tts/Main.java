package com.tts;

public class Main {

    // this main method is known as our entrypoint
    // but in fact, it's also known as our main thread
    // the main thread can create other threads
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world, I'm in a main thread!");

        // We create a new Thread instance
        // we pass a runnable object into that instance
        // thread has a method called start() which it invokes
        // to begin the execution of our runnable

        (new Thread(new HelloRunnable())).start();

        //Second method to run thread
        Thread th = new Thread(new HelloRunnable());
        th.start();

        // Third method to run thread using lambda
        // Keep in mind that Runnable is a functional interface
        // we can use lambda expressions to implement its method
        Runnable task = () ->
                System.out.println("Hello from a lambda! Thread's id: "
                        // This is how we would get the Thread's id
                        + Thread.currentThread().getId());

        // currentThread().getId() will access the id of the thread below
        (new Thread(task)).start();
        //custom thread class
        (new HelloThread()).start();
        // Sleep Message
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "A Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        // List is an interface
        // this is a form of polymorphism
        // List<Integer> myList = new ArrayList<>();
        // Interruption of threads
        // below is an anonymous inner class
        // you can only make lambdas from runnable interfaces
        // below is an anonymous inner class
        // it is legal
        // Supporting Interruption -----------------------------------
        Runnable messageTask = new Runnable(){
            @Override
            public void run() {
                //enhanced for loop

                for (String s : importantInfo) {
                    // Pause for 4 seconds
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // We've been interrupted: no more messages.
                        return;
                    }
                    // Print a message
                    System.out.println(s);
                }

            }
        };

        // Interruption -------------------------------------------
        for (int i =0; i < importantInfo.length; i++){
            // I want to pause the executing thread
            //Pause for 4 seconds = 4000 milliseconds
            Thread.sleep(4000);
            //Print a message after the pause
            System.out.println(importantInfo[i]);
        }

        // method to call messageTask
        (new Thread(messageTask)).start();







    }


}
