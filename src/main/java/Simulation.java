public class Simulation {

    public static synchronized   void startSimulation(Birou b)  {
        boolean flag = true;
        System.out.println(b.getName());
        for (int i = 0; i < b.getNumberOfGhisues(); i++) {

            Ghiseu g = b.getGhiseus().get(i);
            //System.out.println(g);
            if (!g.getClients().isEmpty()) {
                System.out.println(g.getName());
                //System.out.println(g.getClients().size());
                int n = 0;
                if (g.getClients().size() > 0)
                    n = g.getClients().size();
                for (int j = 0; j < n; j++) {
                    System.out.print('*');
                }
                System.out.println();
            } else {
                System.out.println(g.getName());
                System.out.print("\n");
            }
        }
        //Menu.clrscr();

        //flag = false;
    }


}
