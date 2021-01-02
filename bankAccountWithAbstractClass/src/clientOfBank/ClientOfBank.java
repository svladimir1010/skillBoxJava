package clientOfBank;

public abstract class ClientOfBank {
    public ClientOfBank(double money) {
        this.account = money;
    }

    public double account;

    public void showCount() {
        System.out.println("All count- " + this.account);
    }

    public abstract void refill(double money);

    public abstract void withdrawal(double money);

}
