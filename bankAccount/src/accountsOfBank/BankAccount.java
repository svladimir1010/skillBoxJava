package accountsOfBank;

public class BankAccount {
    public double amount;

    public void withdrawMoney(double money) {
        if (isEnoughMoney(money)) this.amount -= money;
        else System.out.println(" На счете не достаточно средств, максимальная сумма снятия- ");
        showAmount();
    }

    public void addMoney(double money) {
        if (money > 0.) this.amount += money;
        else System.out.println("Сумма отрицательна или равна нолю");
        showAmount();
    }

    public void showAmount() {
        System.out.println("Всего на счете- " + amount);
    }

    private boolean isEnoughMoney(double money) {
        return money <= this.amount;
    }
}
//   a. Снять со счёта сумму денег (без комиссии).
//        b. Вносить на счёт сумму денег (без комиссии).
//        c. Получить остаток на счёте.