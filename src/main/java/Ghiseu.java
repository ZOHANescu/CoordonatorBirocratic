import java.util.ArrayList;

public class Ghiseu {

    private boolean state ;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Act> acts = new ArrayList<>();

    public Ghiseu(boolean state, ArrayList<Client> clients, ArrayList<Act> acts) {
        this.state = state;
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

    public ArrayList<Act> getActs() {
        return acts;
    }

    public void setActs(ArrayList<Act> acts) {
        this.acts = acts;
    }
}
