package UserManager;
import java.util.ArrayList;

import Scan.Scan;
import AccountManager.Account;

// 유저 정보 클래스
public class User
{
    public String id, pw, username;
    public ArrayList<Account> accounts;

    public User(String id, String pw, String username)
    {
        this.id = id;
        this.pw = pw;
        this.username = username;
        this.accounts = new ArrayList<>();
    }

    public static User register()
    {
        System.out.print("ID: ");
        String id = Scan.sc.nextLine();
        System.out.print("PW: ");
        String pw = Scan.sc.nextLine();
        System.out.print("사용자명: ");
        String username = Scan.sc.nextLine();
        
        User user = new User(id, pw, username);
        String[] userLoginInfo = {id, pw};
        UserHashMap.userList.put(userLoginInfo, user);

        return user;
    }

    public static void deleteUser(String[] userLoginInfo, User user)
    {
        UserHashMap.userList.remove(userLoginInfo, user);
    }

    public static User login()
    {
        System.out.print("ID: ");
        String id = Scan.sc.nextLine();
        System.out.print("PW: ");
        String pw = Scan.sc.nextLine();

        String[] userLoginInfo = {id, pw};
        return UserHashMap.findUser(userLoginInfo);
    }

    public static void userSetting(User user)
    {
        System.out.println("1 - 유저명 변경");
        System.out.println("2 - 비밀번호 변경");
        System.out.println("3 - 회원 탈퇴");
        System.out.println("Enter - 돌아가기");
        String sel = Scan.sc.nextLine();

        switch (sel) {
            case "1":
                System.out.print("새 유저명을 입력하세요: ");
                String newName = Scan.sc.nextLine();
                user.username = newName;
                System.out.println(String.format("새로운 유저명 '%s'이 적용되었습니다.", user.username));
                break;

            case "2":
                System.out.print("기존 비밀번호를 입력하세요: ");
                String oldPW = Scan.sc.nextLine();

                if (oldPW.equals(user.pw)) {
                    System.out.print("새 비밀번호를 입력하세요: ");
                    String newPw = Scan.sc.nextLine();
                    user.pw = newPw;
                    System.out.println("비밀번호가 변경되었습니다.");
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
                break;

            case "3":
                System.out.println("회원 탈퇴를 위한 유저 확인 절차입니다.");
                System.out.print("ID: ");
                String id = Scan.sc.nextLine();
                System.out.print("PW: ");
                String pw = Scan.sc.nextLine();

                if (id.equals(user.id) && pw.equals(user.pw)) {
                    String[] idPw = {user.id, user.pw};
                    UserHashMap.removeUserFromMap(idPw);
                    System.out.println("회원 탈퇴가 완료되었습니다.");
                } else {
                    System.out.println("유저 정보가 일치하지 않습니다.");
                }
                break;

            default:
                break;
        }
    }
}