import AccountManager.Account;
import UserManager.User;
import Scan.Scan;

public class Bank
{
    public static void main(String[] args)
    {
        loginMenu();
    }
    
    public static void loginMenu()
    {
        System.out.println("자바은행 서비스에 어서오세요!");
        User user = userLogin();
        mainMenu(user);
    }

    public static void mainMenu(User user)
    {
        System.out.println(String.format("%s님 안녕하세요! 어떤 서비스를 이용하시겠습니까?", user.username));
        Bank.selectMenu(user);
    }

    public static User userLogin()
    {
        User user = User.login();
        if (user == null) {  // 로그인 실패 시
            System.out.println("사용자를 찾을 수 없습니다.");
            System.out.println("재시도 - r | 회원 가입 - n | 메인 메뉴 - Enter");
            String input = Scan.sc.nextLine();

            if (input.equals("r"))
                userLogin();
            else if (input.equals("n"))
                user = User.register();
            else
                mainMenu(user);
        }
        return user;
    }

    public static void selectMenu(User user)
    {
        System.out.println("1 - 계좌 관리");
        System.out.println("2 - 대출");
        System.out.println("3 - 계정 설정");
        System.out.println("Enter - 메인 메뉴");
        
        String selection = Scan.sc.nextLine();

        switch (selection) {
            case "1":
                try {
                    user.accounts.get(0).accountMenu();
                } catch (IndexOutOfBoundsException e) {
                    Account.newAccount(user);
                    user.accounts.get(0).accountMenu();
                }
                break;
            case "2":
                System.out.println("대출");
                break;
            case "3":
                User.userSetting(user);
                loginMenu();
                break;
            default:
                mainMenu(user);
                break;
        }
        Bank.selectMenu(user);
    }
}
