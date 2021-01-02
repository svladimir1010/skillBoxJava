package clientOfBank;

public class PersonAccount extends  ClientOfBank{
    public PersonAccount(double money) {
        super(money);
    }

    @Override
    public void refill(double money) {
        if (money > 0) {
            this.account += money;
            System.out.println("You have deposited- " + money + " dollars into your account");
        } else System.out.println("The top-up amount is zero");
        showCount();
    }

    @Override
    public void withdrawal(double money) {
        if (money <= this.account) {
            this.account -= money;
            System.out.println("You withdraw- " + money + " dollars from your account");
        } else System.out.println("There is not enough money in your account");
        showCount();
    }
}
