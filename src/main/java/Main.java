import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
/*
        Act a1 = new Act("alina", null,20);
        List<String> ac=new ArrayList<>();
        List<String> ac1=new ArrayList<>();
        ac.add(a1.getName());
        Act a2= new Act("alina",ac,20);
        ac1.add(a2.getName());
        ac1.add("diana");
        ac1.add("maria");
        ClientsServices.addAct("ana",ac1,30);

*/
        //Menu.menu();
        Kafka.notifyServer();

    }
}
