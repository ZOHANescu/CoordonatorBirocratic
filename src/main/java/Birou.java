import java.util.ArrayList;

public class Birou {
    private String name ;
    private ArrayList<Ghiseu> ghiseus  = new ArrayList<>();

    public Birou(String name, ArrayList<Ghiseu> ghiseus) {
        this.name = name;
        this.ghiseus = ghiseus;
    }
    public void addGhiseus(Ghiseu g){
        this.ghiseus.add(g);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ghiseu> getGhiseus() {
        return ghiseus;
    }

    public void setGhiseus(ArrayList<Ghiseu> ghiseus) {
        this.ghiseus = ghiseus;
    }
}
