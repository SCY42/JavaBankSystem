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
        System.out.println("ID: ");
        String id = Scan.sc.nextLine();
        System.out.println("PW: ");
        String pw = Scan.sc.nextLine();
        System.out.println("Your Username: ");
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

        // 확인용
        System.out.println(String.format("Your ID: %s", id));
        System.out.println(String.format("Your PW: %s", pw));

        String[] userLoginInfo = {id, pw};
        return UserHashMap.findUser(userLoginInfo);
    }
}