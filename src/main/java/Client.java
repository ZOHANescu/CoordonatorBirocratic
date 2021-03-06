import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends Thread {
    private Act wAct;
    private String name;
    private boolean hAct = false;
    public Semaphore sem;
    public Semaphore sem1;
    private long startTime;
    private long endTime;
    private ReentrantLock lock = new ReentrantLock(true);

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public synchronized void searchAct(Act act11) throws InterruptedException {
        // System.out.println(1);
        //Thread.sleep(500);
        // System.out.println("Size " + act11.getMap().size());
        //wait(500);
        if (act11.getMap().isEmpty()) {
            // System.out.println(3);
            //           // wait(1000);
            for (int j = 0; j < Menu.b1.getNumberOfGhisues(); j++) {
                //System.out.println(4);
                // wait(200);
                for (int k = 0; k < Menu.b1.getGhiseus().get(j).getActs().size(); k++) {
                    //System.out.println(5);
                    //wait(200);
                    //System.out.println("actul k " +Menu.b1.getGhiseus().get(j).getActs().get(k));
                    if (Menu.b1.getGhiseus().get(j).getActs().get(k).getName().equals(act11.getName())) {
                        boolean isQueueFull = true;

                        while (isQueueFull) {
                            lock.lock();
                            try {
                                if (Menu.b1.getGhiseus().get(j).getClients().size() >= Menu.b1.getMaxQueueSize()) {
                                    wait(1000);
                                } else {
                                    Menu.b1.getGhiseus().get(j).getClients().add(this);
                                    isQueueFull = false;
                                }
                            } finally {
                                lock.unlock();
                            }
                        }
                        try {
                            sem.acquire();

                            Menu.clrscr();
                            Simulation.startSimulation(Menu.b1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sem.release();
                        Thread.sleep(20);
                        while (Menu.b1.getGhiseus().get(j).getClients().get(0) != this) ; //{System.out.print("");}
                        wait(20 * act11.getTime());

                        Menu.b1.getGhiseus().get(j).getClients().remove(0);
                        notify();
                        try {
                            sem.acquire();
                            Menu.clrscr();
                            Simulation.startSimulation(Menu.b1);
                            this.setEndTime(System.currentTimeMillis());
                            Kafka.notifyServer(name, endTime - startTime, act11.getName());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sem.release();
                        // Thread.sleep(20);
                    }
                }
                //Thread.sleep(20);
            }
        } else {
            ArrayList<Act> a10 = ClientsServices.read1();
            //System.out.println("a10" + a10.toString());
            for (int j = 0; j < act11.getMap().size(); j++) {
                //System.out.println("a11");
                for (int k = 0; k < a10.size(); k++) {
                    //System.out.println("a12");
                    if (act11.getMap().get(j).equals(a10.get(k).getName())) {
                        //System.out.println("A13");
                        searchAct(a10.get(k));
                    }
                }

            }
        }


        hAct = true;
        this.setEndTime(System.currentTimeMillis());
    }


    public void run() {
        //System.out.println("Act run " + wAct.toString());
        //while (!hAct) {
        synchronized (this) {
            try {
                searchAct(wAct);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hAct) {
                Kafka.notifyServer(name, endTime - startTime, wAct.getName());
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public Client(Semaphore sem1, Semaphore sem, String name) {
        Random rand = new Random();
        ArrayList<Act> a10 = ClientsServices.read1();
        System.out.println(a10.toString());
        int i = rand.nextInt(a10.size());
        System.out.println("random " + i);
        wAct = a10.get(i);
        System.out.println(wAct.toString());
        this.sem = sem;
        this.name = name;
        this.sem1 = sem1;
    }

    public Act getwAct() {
        return wAct;
    }

    public void setwAct(Act wAct) {
        this.wAct = wAct;
    }

    public boolean ishAct() {
        return hAct;
    }

    public void sethAct(boolean hAct) {
        this.hAct = hAct;
    }
}
