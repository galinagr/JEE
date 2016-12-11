package jdbc.modules;

public class Prcom {

    private int prcomId;
    private int compId;
    private int projId;

    @Override
    public String toString() {
        return "Prcom{" +
                "prcomId=" + prcomId +
                ", compId=" + compId +
                ", projId=" + projId +
                '}';
    }

    public int getPrcomId() {
        return prcomId;
    }

    public void setPrcomId(int prcomId) {
        this.prcomId = prcomId;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }
}
