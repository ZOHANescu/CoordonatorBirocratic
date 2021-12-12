public class Act {
    private String name;
    private String[] map;
    private int time;

    public Act(String name, String[] map, int time) {
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

    public String[] getMap() {
        return map;
    }

    public void setMap(String[] map) {
        this.map = map;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
