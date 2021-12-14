import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.lang.*;


public class Menu {
    public static void clrscr() {

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {
        }

    }

    public static Birou b1 = new Birou(null, null, 0);
    public static Birou b2 = new Birou(null, null, 0);
    public static Birou b3 = new Birou(null, null, 0);

    public static List<Ghiseu> gs = new ArrayList<>();

    public static List<Ghiseu> lg1 = new ArrayList<>();

    public static boolean t = true;

    public static void menu() throws IOException {

        while (t) {
            System.out.println("Meniu\n");
            System.out.println("1.Add act\n");
            System.out.println("2.Setup Birou\n");
            System.out.println("3.Setup Ghiseu\n");
            System.out.println("4.Start simulation\n");
            System.out.println("4.Stop\n");
            System.out.println("5.Exit\n");

            Scanner scanchoice = new Scanner(System.in);
            int choiceentry = scanchoice.nextInt();

            switch (choiceentry) {
                case 1:
                    Scanner name = new Scanner(System.in);
                    System.out.println("Tape ur act name");
                    String str1 = name.nextLine();
                    System.out.println("Enter ur N names for act map");
                    int n = scanchoice.nextInt();
                    System.out.println("Enter ur " + n + " names");
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
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Tape ur birou name");
                    String b = sc.nextLine();
                    b1.setName(b);
                    System.out.println("Enter number of ghiseus");
                    int nr = sc.nextInt();
                    b1.setNumberOfGhisues(nr);
                    ArrayList<Act> a = ClientsServices.read1();
                    System.out.println(a);
                    System.out.println("nr ghisee " +b1.getNumberOfGhisues());
                    System.out.println("a size " +a.size());
                    int t1 = 0;
                    for (int i = 1; i <= b1.getNumberOfGhisues(); i++) {
                        Random rand = new Random();
                        int rand1;
                        while (a.size() - (rand1 = rand.nextInt(nr - t1)+1) < nr - i) {

                            continue;
                        }
                        t1 = rand1;
                        System.out.println("rand1 " +rand1);
                        ArrayList<Act> a5 = new ArrayList<>();
                        for (int j = 0; j < rand1; j++) {
                            int r;
                            r = rand.nextInt(a.size());
                            System.out.println("r dandom " + r);
                            a5.add(a.get(r));
                           // System.out.println("a get r " + a.get(r));
                            a.remove(r);
                            System.out.println("size a " + a.size());
                        }

                        // Generate random integers in range 0 to 999
                       System.out.println(a5);
                        Ghiseu g1 = new Ghiseu(true, null, a5);
                    }
                    b1.setGhiseus(null);

                    break;
                case 3:

                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(b1.getName());
                    break;
                case 5:
                    System.out.println(5);
                    //System.exit(0);
                    t = false;
                    break;
            }
            clrscr();

        }
    }


}
