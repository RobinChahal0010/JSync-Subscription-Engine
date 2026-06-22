import java.util.*;

class BillingService {
    // Calculates the total bill after applying the plan discount
    double calculateBill(Plan plan, int months) {

        double total = plan.monthlyPrice * months;
        double discount = (total * plan.discount) / 100;

        return total - discount;
    }

    void processFlexible(User user, Plan plan, int months) {

        double bill = calculateBill(plan, months);

        System.out.println("Total Bill: " + bill);

        if (user.balance >= bill) {
            user.balance -= bill;
            System.out.println("Payment SUCCESS");
        } else {
            System.out.println("Payment FAILED - Low Balance");
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

                Calendar cal = Calendar.getInstance();
                cal.setTime(sub.nextBillingDate);
                cal.add(Calendar.MONTH, sub.plan.months);
                sub.nextBillingDate = cal.getTime();

            } else {
                System.out.println("Payment FAILED - Low Balance");
                sub.active = false;
            }
        }
    }
}
