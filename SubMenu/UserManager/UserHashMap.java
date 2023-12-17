package SubMenu.UserManager;
import java.util.HashMap;

public class UserHashMap
{
    static HashMap<String[], User> userList = new HashMap<>(); // 최종적으로는 파일에서 가져오기

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
        if (userList.containsKey(idPw)) {
            User user = userList.get(idPw);
            return user;
        } else {
            return null;
        }
    }
}
