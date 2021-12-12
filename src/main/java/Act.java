import java.util.List;

public class Act {
    private String name;
    private List<String> map;
    private int time;

    public Act(String name, List<String> map, int time) {
        this.name = name;
        this.map = map;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMap() {
        return map;
    }

    public void setMap(List<String> map) {
        this.map = map;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", culoare='" + map + '\'' +
                ", jante='" + time + '\'' +
                '}';
    }
}
