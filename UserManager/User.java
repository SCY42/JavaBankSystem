package UserManager;
import AccountManager.Account;

// 유저 정보 클래스
public class User
{
    String id;
    String pw;
    String username;
    public Account[] accounts = new Account[10];

    public static User newUser()
    {
        User user1 = new User();
        user1.id = "abc";
        user1.pw = "1234";
        user1.username = "42";
        Account acc = new Account(user1.username);
        user1.accounts[0] = acc;

        return user1;
    }
}

