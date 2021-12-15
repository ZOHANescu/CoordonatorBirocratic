import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.concurrent.*;

public class Menu {
    public volatile static Birou b1 = new Birou(null, null, 0);
    public static boolean t = true;
    public static  void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public synchronized static void menu() throws IOException, InterruptedException {

        while (t) {
            System.out.println("Meniu\n");
            System.out.println("1.Add act\n");
            System.out.println("2.Setup Birou\n");
            System.out.println("3.Start simulation\n");
            System.out.println("4.Exit\n");

            Scanner scanchoice = new Scanner(System.in);
            int choiceentry = scanchoice.nextInt();

            switch (choiceentry) {
                case 1:
                    Scanner name = new Scanner(System.in);
                    System.out.println("Tape ur act name");
                    String str1 = name.nextLine();
                    System.out.println("Enter ur N names for act map");
                    int n = scanchoice.nextInt();
                    if (n > 0) {
                        System.out.println("Enter ur " + n + " names");
                    }
                    List<String> l1 = new ArrayList<>();
                    Scanner scanner = new Scanner(System.in);
                    while (n > 0) {
                        String tokens = scanner.nextLine();
                        l1.add(tokens);
                        n = n - 1;
                    }
                    System.out.println("Enter time to wait");
                    int time = scanchoice.nextInt();
                    ClientsServices.addAct(str1, l1, time);
                    break;
                case 2:
                    List<Ghiseu> gs = new ArrayList<>();
                    b1.setGhiseus(gs);
                    b1.setName(null);
                    //gs.clear();
                    //b1.setNumberOfGhisues(0);
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Tape ur birou name");
                    String b = sc.nextLine();
                    b1.setName(b);
                    System.out.println("Enter number of ghiseus");
                    int nr = sc.nextInt();
                    ArrayList<Act> a = ClientsServices.read1();
                    System.out.println("A "+ a);
                    if (nr <= a.size()) {
                        b1.setNumberOfGhisues(nr);
                        int t1 = 0;
                        int gh=0 ;
                        System.out.println(" nr ghis " + b1.getNumberOfGhisues());
                        for (int i = 1; i < b1.getNumberOfGhisues(); i++) {
                            Random rand = new Random();
                            int rand1;

                            System.out.println("size a " + a.size());
                            while (a.size() - (rand1 = rand.nextInt(a.size())+1) < nr - i) {
                                continue;
                            }
                            System.out.println("rand 1 " + rand1);
                            t1 = rand1;
                            ArrayList<Act> a5 = new ArrayList<>();
                            for (int j = 0; j < rand1; j++) {
                                int r;
                                r = rand.nextInt(a.size());
                                a5.add(a.get(r));
                                a.remove(r);
                            }
                            System.out.println("New a "+ a);
                            System.out.println("acte  " + a5);
                            ArrayList<Client> actes1 = new ArrayList<>();
                            Ghiseu g1 = new Ghiseu(true, "Ghiseu" + i, actes1, a5);
                            System.out.println("ghiseu "+ g1);
                            gs.add(g1);

                        }
                        ArrayList<Act> a4 = new ArrayList<>();
                        System.out.println("new a " +a);
                        a4.addAll(a);
                        ArrayList<Client> actessss = new ArrayList<>();
                        System.out.println("last act " + a4);
                        Ghiseu g2 = new Ghiseu(true, "Ghiseu" + b1.getNumberOfGhisues(), actessss, a4);
                        System.out.println(g2);
                        gs.add(g2);
                        b1.setGhiseus(gs);
                        System.out.println("birou "+ b1);
                    } else {
                        clrscr();
                        System.out.println("Number of acts < number of ghisee \n");
                        System.out.println("Press any key to continue..");
                        Scanner sc18 = new Scanner(System.in);
                        String b18 = sc18.nextLine();
                    }
                    break;
                case 3:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Number of clients");
                    int numberC = sc1.nextInt();
                    Semaphore sem = new Semaphore(1);
                    List<Client> list = new ArrayList<>();
                    for (int i = 0; i < numberC; i++) {
                        list.add(new Client(sem));
                        //list.get(i).start();
                        //list.get(i).join();
                    }
                    for (int i = 0; i <numberC; i++) {
                        list.get(i).start();
                    }
                    for (int i = 0; i <numberC; i++) {
                        list.get(i).join();
                    }
                   // c1.start();
                   // c2.start();
                    //c1.join();
                   // c2.join();
                    //c3.start();
                   //c3.join();
                    //c4.start();
                    //c4.join();
                   // while(c1.isAlive() || c2.isAlive() || c3.isAlive() || c4.isAlive());
                    Thread.sleep(5000);
                   // Simulation.startSimulation(b1);
                    break;
                case 4:
                    t = false;
                    break;
            }
            clrscr();
        }
    }


}
