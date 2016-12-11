package jdbc.modules;

public class Projects {

    private int projId;
    private int costs;
    private int profit;
    private String projectDesc;
    private String projectName;
    private int quantityDev;

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projId=" + projId +
                ", costs=" + costs +
                ", profit=" + profit +
                ", projectDesc='" + projectDesc + '\'' +
                ", projectName='" + projectName + '\'' +
                ", quantityDev=" + quantityDev +
                '}';
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getQuantityDev() {
        return quantityDev;
    }

    public void setQuantityDev(int quantityDev) {
        this.quantityDev = quantityDev;
    }
}
