import java.util.Scanner;

import UserManager.User;

public class Bank
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        mainMenu();
    }

    public static void mainMenu()
    {
        System.out.println("00은행 서비스에 어서오세요!");
        User user = userLogin();
        System.out.println(String.format("%s님 안녕하세요! 어떤 서비스를 이용하시겠습니까?", user.username));
        Bank.selectMenu(user);
    }

    public static User userLogin()
    {
        User user = User.login();
        if (user == null) {  // 로그인 실패 시
            System.out.println("사용자를 찾을 수 없습니다.");
            System.out.println("재시도 - r | 회원 가입 - n | 메인 메뉴 - Enter");
            String input = sc.nextLine();

            if (input == "r")
                userLogin();
            else if (input == "n")
                User.register();
            else
                mainMenu();
        }
        return user;
    }

    public static void selectMenu(User user)
    {
        System.out.println("1 - 계좌 관리");
        System.out.println("2 - 대출");
        System.out.println("3 - 계정 설정");

        String selection = sc.nextLine();

        switch (selection) {
            case "1":
                user.accounts.get(0).AccountMenu();
                break;
            case "2":
                System.out.println("대출");
                break;
            case "3":
                System.out.println("계정 설정");
                break;
            default:
                System.out.println("잘못된 입력");
                break;
        }
        Bank.selectMenu(user);
    }
}
