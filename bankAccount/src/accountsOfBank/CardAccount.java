package accountsOfBank;

public class CardAccount extends BankAccount {
    private static final double WITHDRAW_PERCENT = .01;

    public void setWithdrawPercent(double money) {
        money += withPercent(money);
        System.out.println("Сумма снятия с процентом :" + money);
        super.withdrawMoney(amount);
    }

    private static double withPercent(double amount) {
        return amount * WITHDRAW_PERCENT;
    }
}
//        Карточный счёт, при снятии денег с которого
//        будет взиматься комиссия 1%.