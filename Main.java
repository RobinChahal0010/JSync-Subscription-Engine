import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SYSTEM =====");
        System.out.println("1. Flexible Payment (user months)");
        System.out.println("2. Auto Subscription System");

        int mode = sc.nextInt();

        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        User user = new User(name, balance);

        Plan basic = new Plan("Basic", 199, 0);
        Plan standard = new Plan("Standard", 499, 10);
        Plan premium = new Plan("Premium", 799, 20);

        BillingService bs = new BillingService();

        if (mode == 1) {

            System.out.println("\nChoose Plan:");
            System.out.println("1. Basic 2. Standard 3. Premium");

            int choice = sc.nextInt();

            System.out.print("Enter months: ");
            int months = sc.nextInt();

            Plan selected = (choice == 1) ? basic :
                            (choice == 2) ? standard : premium;

            bs.processFlexible(user, selected, months);

        } else {

            Plan selected = premium;

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);

            Subscription sub = new Subscription(user, selected, cal.getTime());

            bs.processBilling(sub);
        }

        System.out.println(

        sc.close();
    }
}
