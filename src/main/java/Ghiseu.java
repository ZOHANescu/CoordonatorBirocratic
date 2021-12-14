import java.util.ArrayList;
import java.util.List;

public class Ghiseu {

    private boolean state ;
    private String name;
    private ArrayList<Client> clients = new ArrayList<>();
    private List<Act> acts = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ghiseu(boolean state, String name, ArrayList<Client> clients, List<Act> acts) {
        this.state = state;
        this.name = name;
        this.clients = clients;
        this.acts = acts;
    }

    public void addClients(Client client){

        this.clients.add(client);
    }
    public void addActs(Act act){

        this.acts.add(act);
    }
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void setActs(ArrayList<Act> acts) {
        this.acts = acts;
    }

    @Override
    public String toString() {
        return "Ghiseu{" +
                "state=" + state +
                ", name='" + name + '\'' +
                ", clients=" + clients +
                ", acts=" + acts +
                '}';
    }
}
