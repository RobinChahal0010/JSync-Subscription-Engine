class Plan {
    String name;
    double monthlyPrice;
    double discount; 

    int months; 

    Plan(String name, double monthlyPrice, double discount) {
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.discount = discount;
        this.months = 1;
    }

    Plan(String name, double monthlyPrice, double discount, int months) {
        this.name = name;
        this.monthlyPrice = monthlyPrice;
        this.discount = discount;
        this.months = months;
    }
}