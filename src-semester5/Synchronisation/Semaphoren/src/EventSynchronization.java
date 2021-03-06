class Thread_1 extends Thread {
    private Semaphore[] sems;

    public Thread_1(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    private void Activity_1() {
        System.out.println("Activity_1 running");
    }

    public void run() {
        Activity_1();
        sems[0].v();
        sems[1].v();
    }
}

class Thread_2 extends Thread {
    private Semaphore[] sems;

    public Thread_2(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    private void Activity_2() {
        System.out.println("Activity_2 running");
    }

    public void run() {
        sems[0].p();
        Activity_2();
        sems[2].v();
    }
}

class Thread_3 extends Thread {
    private Semaphore[] sems;

    public Thread_3(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    private void Activity_3() {
        System.out.println("Activity_3 running");
    }

    public void run() {
        sems[1].p();
        Activity_3();
        sems[3].v();
    }
}

class Thread_4 extends Thread {
    private Semaphore[] sems;

    public Thread_4(Semaphore[] sems, String name) {
        super(name);
        this.sems = sems;
        start();
    }

    private void Activity_4() {
        System.out.println("Activity_4 running");
    }

    public void run() {
        sems[2].p();
        sems[3].p();
        Activity_4();
    }
}

public class EventSynchronization {
    public static void main(String[] args) {
        Semaphore[] sems = new Semaphore[6];
        for (int i = 0; i < sems.length; i++) {
            sems[i] = new Semaphore(0);
        }
        new Thread_4(sems, "Thread_4");
        new Thread_1(sems, "Thread_1");
        new Thread_3(sems, "Thread_3");
        new Thread_2(sems, "Thread_2");


    }
}
