import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.lang.*;



public class Menu {
    public static void clrscr(){

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }
    public static  boolean t = true;
    public static void menu() throws IOException {

        while(t){
            System.out.println("Meniu\n");
            System.out.println("1.Add act\n");
            System.out.println("2.Setup Birou\n");
            System.out.println("3.Setup Ghiseu\n");
            System.out.println("4.Start simulation\n");
            System.out.println("4.Stop\n");
            System.out.println("5.Exit\n");

        Scanner scanchoice = new Scanner(System.in);
        int choiceentry = scanchoice.nextInt();

        switch(choiceentry) {
            case 1:
                Scanner name = new Scanner(System.in);
                System.out.println("Tape ur act name");
                String str1 = name.nextLine();
                System.out.println("Enter ur N names for act map");
                int n = scanchoice.nextInt();
                System.out.println("Enter ur " + n + " names");
                List<String> l1 = new ArrayList<>();
                Scanner scanner = new Scanner(System.in);
                while (n >  0)
                {
                    String tokens = scanner.nextLine();
                    l1.add(tokens);
                    n= n -1;
                }


                System.out.println("Enter time to wait");
                int time = scanchoice.nextInt();
                ClientsServices.addAct(str1, l1, time);

                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
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
