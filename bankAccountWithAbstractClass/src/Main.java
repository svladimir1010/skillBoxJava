import clientOfBank.EmployerAccount;

public class Main {
    public static void main(String[] args) {
        EmployerAccount employerAccount = new EmployerAccount(100);
        employerAccount.refill(100);
        employerAccount.refill(100);
        employerAccount.withdrawal(50);
    }
}
