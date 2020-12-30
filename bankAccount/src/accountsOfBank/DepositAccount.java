package accountsOfBank;

import java.time.LocalDateTime;

public class DepositAccount extends BankAccount {
    private static LocalDateTime lastDeposit;

    public void addMoney(double money) {
        super.addMoney(money);
        lastDeposit = LocalDateTime.now();
    }

    public void withdrawMoney(double money) {
        if (lastDeposit.plusMonths(1).isBefore(LocalDateTime.now())) {
            super.withdrawMoney(money);
        } else {
            System.out.println("Снять можно через месяц после внесения средств.");
        }
    }
}

//        Депозитный расчётный счёт, с которого нельзя снимать
//        деньги в течение месяца после последнего внесения.