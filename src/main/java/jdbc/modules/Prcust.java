package jdbc.modules;

public class Prcust {
    private int prcustId;
    private int custId;
    private int projId;

    @Override
    public String toString() {
        return "Prcust{" +
                "prcustId=" + prcustId +
                ", custId=" + custId +
                ", projId=" + projId +
                '}';
    }

    public int getPrcustId() {
        return prcustId;
    }

    public void setPrcustId(int prcustId) {
        this.prcustId = prcustId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }
}
