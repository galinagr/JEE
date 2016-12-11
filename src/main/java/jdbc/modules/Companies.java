package jdbc.modules;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "COMPANIES", schema = "GALINA")
public class Companies {

    private int compId;
    private String compName;
    private String compAddr;

    @Override
    public String toString() {
        return "Companies{" +
                "compId=" + compId +
                ", compName='" + compName + '\'' +
                ", compAddr='" + compAddr + '\'' +
                '}';
    }

    public int getCompId() {
        return compId;
    }

    public void setcompId(int compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setcompName(String compName) {
        this.compName = compName;
    }

    public String getCompAddr() {
        return compAddr;
    }

    public void setcompAddr(String compAddr) {
        this.compAddr = compAddr;
    }
}
