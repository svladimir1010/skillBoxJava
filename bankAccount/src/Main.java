import accountsOfBank.BankAccount;
import accountsOfBank.CardAccount;
import accountsOfBank.DepositAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        DepositAccount depositAccount = new DepositAccount();
        CardAccount cardAccount = new CardAccount();

//        bankAccount.addMoney(1000);
//        bankAccount.withdrawMoney(1100);

//        depositAccount.showAmount();
//        depositAccount.addMoney(1000);
//        depositAccount.withdrawMoney(300);
    }
}



//    Цель задания
//    Освоить на практике наследование классов.
//        Что нужно сделать
//        1. Создайте класс BankAccount, который представляет собой расчётный счёт в банке.
//        У класса необходимо написать методы:
//        a. Снять со счёта сумму денег (без комиссии).
//        b. Вносить на счёт сумму денег (без комиссии).
//        c. Получить остаток на счёте.
//        2. Создайте два класса наследника, расширяющие работу с остатком на счёте:
//        Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
//        Карточный счёт, при снятии денег с которого будет взиматься комиссия 1%.
