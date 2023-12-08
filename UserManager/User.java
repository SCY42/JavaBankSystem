package UserManager;
import AccountManager.Account;

// 유저 정보 클래스
public class User {
    String id;
    String pwd;
    String username;
    Account[] accounts = new Account[10];
}
