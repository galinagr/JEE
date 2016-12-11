package jdbc.modules;

public class Developers {
    private String forname;
    private String surname;
    private int devId;
    private String posInProject;
    private int salary;

    public String getDateOfEmp() { return dateOfEmp; }

    @Override
    public String toString() {
        return "Developers{" +
                "forname='" + forname + '\'' +
                ", surname='" + surname + '\'' +
                ", devId=" + devId +
                ", posInProject='" + posInProject + '\'' +
                ", salary=" + salary +
                ", dateOfEmp='" + dateOfEmp + '\'' +
                '}';
    }

    private String dateOfEmp;

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getPosInProject() {
        return posInProject;
    }

    public void setPosInProject(String posInProject) {
        this.posInProject = posInProject;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDateOfEmp(String dateOfEmp) {
        this.dateOfEmp = dateOfEmp;
    }
}
