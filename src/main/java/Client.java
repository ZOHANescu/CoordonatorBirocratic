import java.lang.*;
import java.util.ArrayList;
import java.util.Random;

public class Client extends Thread {
    private Act wAct;
    private boolean hAct = false;


    public void searchAct(Act act11){
        for (int i = 0; i < act11.getMap().size(); i++) {
            if(this.wAct.getMap().isEmpty()){
                for (int j = 0; j <Menu.b1.getNumberOfGhisues() ; j++) {
                    for (int k = 0; k <Menu.b1.getGhiseus().get(j).getActs().size() ; k++) {
                        if(Menu.b1.getGhiseus().get(j).getActs().get(k).getName().equals(act11.getName())){
                            Menu.b1.getGhiseus().get(j).getClients().add(this);
                            Simulation.startSimulation(Menu.b1);
                            while(Menu.b1.getGhiseus().get(j).getClients().get(0)!=this){
                                continue;
                            }
                            Menu.b1.getGhiseus().get(j).getClients().remove(0);
                            Simulation.startSimulation(Menu.b1);
                        }
                    }
                }
            }else{
                ArrayList<Act> a10 = ClientsServices.read1();
                for (int j = 0; j <act11.getMap().size() ; j++) {
                    for (int k = 0; k <a10.size() ; k++) {
                        if(act11.getMap().get(j).equals(a10.get(k).getName())){
                            searchAct(a10.get(k));
                        }
                    }

                }
            }

        }
        this.hAct = true;
    }


    public void run() {
        while (!hAct) {
            searchAct(this.wAct);

            Client c1 = new Client();
            for (int i = 0; i < Menu.b1.getNumberOfGhisues(); i++) {
                Menu.b1.getGhiseus().get(i).getClients().add(c1);
            }
            Simulation.startSimulation(Menu.b1);
            Menu.clrscr();
            for (int i = 0; i < Menu.b1.getNumberOfGhisues(); i++) {
                Menu.b1.getGhiseus().get(i).getClients().remove(0);
            }
            Simulation.startSimulation(Menu.b1);
            Menu.clrscr();

        }
    }

    public Client() {
        Random random =  new Random();
        ArrayList<Act> a10 = ClientsServices.read1();
        int i = random.nextInt(a10.size());
        this.wAct = a10.get(i);
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
