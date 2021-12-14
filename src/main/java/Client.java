import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client extends Thread {
    private Act wAct;
    private boolean hAct = false;


    public void searchAct(Act act11) throws InterruptedException {
        System.out.println(1);
        System.out.println("Size " + act11.getMap().size());
        if (act11.getMap().isEmpty()) {
            System.out.println(3);
            for (int j = 0; j < Menu.b1.getNumberOfGhisues(); j++) {
                System.out.println(4);
                for (int k = 0; k < Menu.b1.getGhiseus().get(j).getActs().size(); k++) {
                    System.out.println(5);
                    if (Menu.b1.getGhiseus().get(j).getActs().get(k).getName().equals(act11.getName())) {

                        Menu.b1.getGhiseus().get(j).getClients().add(this);
                        Menu.clrscr();
                        Simulation.startSimulation(Menu.b1);
                        while (Menu.b1.getGhiseus().get(j).getClients().get(0) != this) ;
                        Thread.sleep(act11.getTime() *100 );
                        Menu.b1.getGhiseus().get(j).getClients().remove(0);
                        Menu.clrscr();
                        Simulation.startSimulation(Menu.b1);
                        Menu.clrscr();
                    }
                }
            }
        } else {
            ArrayList<Act> a10 = ClientsServices.read1();
            System.out.println("a10" + a10.toString());
            for (int j = 0; j < act11.getMap().size(); j++) {
                System.out.println("a11");
                for (int k = 0; k < a10.size(); k++) {
                    System.out.println("a12");
                    if (act11.getMap().get(j).equals(a10.get(k).getName())) {
                        System.out.println("A13");
                        searchAct(a10.get(k));
                    }
                }

            }
        }



    hAct =true;
}


    public void run() {
        System.out.println("Act run " + wAct.toString());
        while (!hAct) {
        try {
            searchAct(wAct);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public Client() {
        Random rand = new Random();
        ArrayList<Act> a10 = ClientsServices.read1();
        System.out.println(a10.toString());
        int i = rand.nextInt(a10.size());
        System.out.println("random " + i);
        wAct = a10.get(i);
        System.out.println(wAct.toString());
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
