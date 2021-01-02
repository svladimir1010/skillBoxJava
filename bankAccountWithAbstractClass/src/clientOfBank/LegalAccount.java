package clientOfBank;

public class LegalAccount extends  PersonAccount{
    private static final double WITHDRAW_PERCENT = .01;

    public LegalAccount(double money) {
        super(money);
    }

    @Override
    public void withdrawal(double money) {
        if (money == 0) return;
        if (money >= this.account) {
            System.out.println("There is not enough money in your account");
        } else {
            money += withPercent(money);
            account -= money;
            System.out.println("Сумма снятия с процентом : " + account);
        }
    }

    private static double withPercent(double money) {
        return money * WITHDRAW_PERCENT;
    }
}
