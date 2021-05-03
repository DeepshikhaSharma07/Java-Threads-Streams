package com.tts;

public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from a thread! Here is the thread's ID: " + Thread.currentThread().getId());
    }
}
