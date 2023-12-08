package AccountManager;

public class Account
{
    String owner;
    int balance = 0;

    Account(String name)
    {
        this.owner = name;
    }

    public void deposit(int amount)
    {
        this.balance += amount;
    }

    public void withdraw(int amount)
    {
        this.balance -= amount;
    }
}
