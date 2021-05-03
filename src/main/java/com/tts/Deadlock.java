package com.tts;

public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend micha =
                new Friend("Micha");
        final Friend pierre =
                new Friend("Pierre");

        // Lambda-------
        //   new Thread(()->micha.bow(pierre)).start();
        //  new Thread(()->pierre.bow(micha)).start();

        new Thread(new Runnable() {
            public void run() { micha.bow(pierre); }
        }).start();
        new Thread(new Runnable() {
            public void run() { pierre.bow(micha); }
        }).start();
    }

}
