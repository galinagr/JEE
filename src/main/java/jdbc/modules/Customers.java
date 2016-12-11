package jdbc.modules;

public class Customers {

    private int custId;
    private int custExpenses;
    private String custName;

    @Override
    public String toString() {
        return "Customers{" +
                "custId=" + custId +
                ", custExpenses=" + custExpenses +
                ", custName='" + custName + '\'' +
                '}';
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustExpenses() {
        return custExpenses;
    }

    public void setCustExpenses(int custExpenses) {
        this.custExpenses = custExpenses;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
