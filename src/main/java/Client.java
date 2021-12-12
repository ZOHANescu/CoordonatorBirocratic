public class Client {
    private Act wAct ;
    private boolean hAct = false;

    public Client(Act wAct, boolean hAct) {
        this.wAct = wAct;
        this.hAct = hAct;
    }

    public Act getwAct() {
        return wAct;
    }

    public void setwAct(Act wAct) {
        this.wAct = wAct;
    }

    public boolean ishAct() {
        return hAct;
    }

    public void sethAct(boolean hAct) {
        this.hAct = hAct;
    }
}
