import java.util.Scanner;

public class Bank
{
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Hello!");
        Bank bank = new Bank();
        bank.login();
        // 다른 메소드들을 스태틱으로 변경할 예정
    }

    public void login()
    {
        System.out.println("Your ID: ");
        String id = this.sc.nextLine();
        System.out.println(id);
    }

    public void selectMenu()
    {
        System.out.println("Select Menu: ");
        String menu = this.sc.nextLine();
        System.out.println(menu);
    }
}