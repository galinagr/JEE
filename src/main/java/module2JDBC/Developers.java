package module2JDBC;


public class Developers {
    private String FORNAME;
    private String SURNAME;
    private int DEV_ID;
    private String POS_IN_PROJECT;
    private int SALARY;

    public String getDATE_OF_EMP() {
        return DATE_OF_EMP;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "FORNAME='" + FORNAME + '\'' +
                ", SURNAME='" + SURNAME + '\'' +
                ", DEV_ID=" + DEV_ID +
                ", POS_IN_PROJECT='" + POS_IN_PROJECT + '\'' +
                ", SALARY=" + SALARY +
                ", DATE_OF_EMP='" + DATE_OF_EMP + '\'' +
                '}';
    }

    private String DATE_OF_EMP;

    public String getFORNAME() {
        return FORNAME;
    }

    public void setFORNAME(String FORNAME) {
        this.FORNAME = FORNAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public int getDEV_ID() {
        return DEV_ID;
    }

    public void setDEV_ID(int DEV_ID) {
        this.DEV_ID = DEV_ID;
    }

    public String getPOS_IN_PROJECT() {
        return POS_IN_PROJECT;
    }

    public void setPOS_IN_PROJECT(String POS_IN_PROJECT) {
        this.POS_IN_PROJECT = POS_IN_PROJECT;
    }

    public int getSALARY() {
        return SALARY;
    }

    public void setSALARY(int SALARY) {
        this.SALARY = SALARY;
    }



    public void setDATE_OF_EMP(String DATE_OF_EMP) {
        this.DATE_OF_EMP = DATE_OF_EMP;
    }
}
