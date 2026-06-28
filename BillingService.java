import java.util.*;

class BillingService {
    
    // User ID 
    HashMap<Integer, ArrayList<Transaction>> transactionHistory =
            new HashMap<>();

    // Calculates the total bill after applying the plan discount
    double calculateBill(Plan plan, int months) {
        // Calculate the total amount before discount
        double total = plan.monthlyPrice * months;
        // Calculate discount amount based on the plan's discount percentage
        double discount = (total * plan.discount) / 100;
        // Return the final bill after subtracting the discount
        return total - discount;
    }
    // Adds a transaction to the user's history
    void addTransaction(User user,
                        double amount,
                        String status){

        transactionHistory
                .computeIfAbsent(user.userId,
                        k -> new ArrayList<>())
                .add(new Transaction(amount, status));
    }
    // Handles one-time/flexible billing chosen by the user
    void processFlexible(User user, Plan plan, int months) {

        double bill = calculateBill(plan, months);

        System.out.println("Total Bill: " + bill);

        if (user.balance >= bill) {
            user.balance -= bill;
            System.out.println("Payment SUCCESS");
            addTransaction(user, bill, "SUCCESS");
        } else {
            System.out.println("Payment FAILED - Low Balance");
            addTransaction(user, bill, "FAILED");
        }
    }

    
    void processBilling(Subscription sub) {

        if (!sub.active) return;

        Date today = new Date();

        if (today.after(sub.nextBillingDate)) {

            System.out.println("Processing billing for: " + sub.user.name);

            double bill = sub.plan.monthlyPrice;

            if (sub.user.balance >= bill) {

                sub.user.balance -= bill;

                System.out.println("Payment SUCCESS: " + bill);
                addTransaction(sub.user, bill, "SUCCESS");

                Calendar cal = Calendar.getInstance();
                cal.setTime(sub.nextBillingDate);
                cal.add(Calendar.MONTH, sub.plan.months);
                sub.nextBillingDate = cal.getTime();

            } else {
                System.out.println("Payment FAILED - Low Balance");
                addTransaction(sub.user, bill, "FAILED");
                sub.active = false;
            }
        }
    }
}
