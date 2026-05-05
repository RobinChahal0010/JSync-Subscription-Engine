import java.util.Date;
public class Subscription {
    User user;
    Plan plan;
    Date nextBillingDate;
    boolean active= true;

    public Subscription(User user,Plan plan,Date nextBillingDate) {
        this.user=user;
        this.plan=plan;
        this.nextBillingDate=nextBillingDate;
    }

    void cancel(){
        active=false;
        System.out.println("Subscription Cancelled");
    }
    

    
}
