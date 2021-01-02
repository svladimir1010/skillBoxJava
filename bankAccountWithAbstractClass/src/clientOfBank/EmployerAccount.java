package clientOfBank;

public class EmployerAccount extends  PersonAccount{
    private static final double MAX_WITHDRAW_PERCENT = .01;
    private static final double MIN_WITHDRAW_PERCENT = .005;

    public EmployerAccount(double money) {
        super(money);
    }

    public void refill(double money) {
        money = percentOfRefill(money);
        if (money > 0) {
            this.account += money;
            System.out.println("You have deposited- " + money + " dollars into your account");
        } else System.out.println("The top-up amount is zero");
        showCount();
    }
    private static double percentOfRefill(double money) {
        if (money >= 1000.0) money = money - money * MIN_WITHDRAW_PERCENT;
        if (money < 1000.0) money = money - money * MAX_WITHDRAW_PERCENT;
        return money;
    }
}
