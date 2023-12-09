import java.util.Scanner;
import UserManager.User;
import UserManager.UserHashMap;
import AccountManager.Account;


public class Bank
{
    public static void main(String[] args)
    {
        System.out.println("00은행 서비스에 어서오세요!");
        User user = Bank.login();
        System.out.println(String.format("%s님 안녕하세요! 어떤 서비스를 이용하시겠습니까?", user.username));
        Bank.selectMenu(user);
    }
    
    public static User login()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("PW: ");
        String pw = sc.nextLine();

        sc.close();
        // 확인용
        System.out.println(String.format("Your ID: %s", id));
        System.out.println(String.format("Your PW: %s", pw));

        String[] userLoginInfo = {id, pw};
        return UserHashMap.findUser(userLoginInfo);
    }

    public static void selectMenu(User user)
    {
        System.out.println("1 - 계좌 관리");
        System.out.println("2 - 대출");
        System.out.println("3 - 환전");
        System.out.println("4 - 계정 설정");

        Scanner sc = new Scanner(System.in);
        String selection = sc.nextLine();
        sc.close();

        switch (selection) {
            case "1":
                user.accounts[0].AccountMenu();
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
        Bank.selectMenu(user);
    }
}