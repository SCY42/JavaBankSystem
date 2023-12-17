package UserManager;
import java.util.HashMap;

public class UserHashMap
{
    public static HashMap<String[], User> userList = new HashMap<>(); // 최종적으로는 파일에서 가져오기
    // User testUser = new User("a", "a", "asdf");
    
    public static void addUserToMap(String[] idPw, User user)
    {
        UserHashMap.userList.put(idPw, user);
    }

    public static void removeUserFromMap(String[] idPw)
    {
        UserHashMap.userList.remove(idPw);
    }

    public static User findUser(String[] idPw)
    {
        User user = userList.get(idPw);
        return user;
    }
}
