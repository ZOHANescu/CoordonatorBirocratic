import java.util.ArrayList;
import java.util.List;

public class Birou {
    private String name ;
    private int numberOfGhisues ;
    private List<Ghiseu> ghiseus  = new ArrayList<>();

    public Birou(String name,List<Ghiseu> ghiseus,int nb) {
        this.name = name;
        this.ghiseus = ghiseus;
        this.numberOfGhisues = nb;
    }
    public void addGhiseus(Ghiseu g){
        this.ghiseus.add(g);
    }
    public String getName() {
        return name;
    }

    public int getNumberOfGhisues() {
        return numberOfGhisues;
    }

    public void setNumberOfGhisues(int numberOfGhisues) {
        this.numberOfGhisues = numberOfGhisues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ghiseu> getGhiseus() {
        return ghiseus;
    }

    public void setGhiseus(List<Ghiseu> ghiseus) {
        this.ghiseus = ghiseus;
    }

    @Override
    public String toString() {
        return "Birou{" +
                "name='" + name + '\'' +
                ", numberOfGhisues=" + numberOfGhisues +
                ", ghiseus=" + ghiseus +
                '}';
    }
}
