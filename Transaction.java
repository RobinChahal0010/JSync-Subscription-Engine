import java.util.Date;

class Transaction {

    double amount;
    String status;
    Date date;

    Transaction(double amount, String status) {
        this.amount = amount;
        this.status = status;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Amount: " + amount +
               ", Status: " + status +
               ", Date: " + date;
    }
}