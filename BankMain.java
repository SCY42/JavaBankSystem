import java.util.Scanner;
import UserManager.User;
import AccountManager.Account;

public class BankMain
{
    Scanner sc = new Scanner(System.in);
    String id;
    String pw;
    User user;

    public static void main(String[] args)
    {
        BankMain bank = new BankMain();
        bank.mainMenu();
    }
    
    public void mainMenu()
    {        
        User newUser = User.newUser();
        this.user = newUser;
        System.out.println("00은행 서비스에 어서오세요!");
        this.login();
        System.out.println(String.format("%s님 안녕하세요! 어떤 서비스를 이용하시겠습니까?", this.id));
        this.selectMenu();
    }

    public void login()
    {
        System.out.print("ID: ");
        this.id = this.sc.nextLine();
        System.out.print("PW: ");
        this.pw = this.sc.nextLine();
        // 확인용
        System.out.println(String.format("Your ID: %s", this.id));
        System.out.println(String.format("Your PW: %s", this.pw));

    }

    public void selectMenu()
    {
        System.out.println("1 - 계좌 관리");
        System.out.println("2 - 대출");
        System.out.println("3 - 환전");
        System.out.println("4 - 계정 설정");
        String selection = this.sc.nextLine();

        switch (selection) {
            case "1":
                Account a = this.user.accounts[0];
                a.AccountMenu();
                break;
            case "2":
                System.out.println("대출");
                break;
            case "3":
                System.out.println("환전");
                break;
            case "4":
                System.out.println("계정 설정");
                break;
            default:
                System.out.println("잘못된 입력");
                break;
        }
        this.selectMenu();
    }
}