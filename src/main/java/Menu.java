import java.util.ArrayList;

public class Menu {
   private ArrayList<User> users = new ArrayList<User>();

    public String addUser(User user){
        this.users.add(user);
        return user.userName + " added successfully!";
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public User getSingleUser(int userId){
        return this.users.get(userId);
    }
    public String removeUser(int userId){
        try{
            users.remove(userId);
        }catch (Exception ex){
            return  "Unable to remove contact";
        }
        return "Contact removed successfully!";
    }
    public String updateUser(int userIndex, User newUser){
        if(this.users.get(userIndex) != null){
            User oldUser = this.users.get(userIndex);
            oldUser.userName = newUser.userName;
            oldUser.userPhone = newUser.userPhone;
            oldUser.userEmail = newUser.userEmail;
            return "User updated successfully!";
            }
        return "User not found!";
    }

}
