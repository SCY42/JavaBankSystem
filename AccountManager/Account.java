package AccountManager;

import java.util.Scanner;

public class Account
{
    public String owner;
    public int number;
    public int balance = 0;
    Scanner sc = new Scanner(System.in);

    public Account(String name)
    {
        this.owner = name;
        this.number = (int)(Math.random() * (int)Math.pow(10, 10));
    }

    public void AccountMenu()
    {
        System.out.println("1 - 입금");
        System.out.println("2 - 출금");
        System.out.println("3 - 이체");
        System.out.println("4 - 거래 내역 조회");
        String selection = this.sc.nextLine();

        switch (selection) {
            case "1":
                this.deposit();
                break;
            case "2":
                this.withdraw();
                break;
            case "3":
                System.out.println("이체");
                break;
            case "4":
                System.out.println("거래 내역 조회");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }

    public void deposit()
    {
        System.out.println("입금할 금액을 입력하세요: ");
        try {
            int amount = Integer.parseInt(this.sc.nextLine());
            this.balance += amount;
            System.out.println(String.format("성공적으로 %d원이 입금되었습니다!", amount));
            System.out.println(String.format("현재 잔액: %d", this.balance));
        }
        catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            this.deposit();
        }
    }

    public void withdraw()
    {
        System.out.println("출금할 금액을 입력하세요: ");
        try {
            int amount = Integer.parseInt(this.sc.nextLine());
            this.balance -= amount;
            System.out.println(String.format("성공적으로 %d원이 출금되었습니다!"));
            System.out.println(String.format("현재 잔액: %d", this.balance));
        }
        catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            this.deposit();
        }
    }
}