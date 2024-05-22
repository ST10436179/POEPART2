import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
        public String username;
        public String firstName = "";
        public String lastName = "";
        public String password;
        public boolean isValidUser;
        public boolean isValidPassword;

        public boolean isLoginIn = false;




    public boolean checkUserName(String username) {

        return username.length() <= 5 && username.contains("_");
    };

    public boolean checkPasswordComplexity(String password) {
        boolean isValidPassword = false;


        if(password.length() > 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")){
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasSpecial = special.matcher(password);
            if(hasSpecial.find()){
                isValidPassword = true;
            }else{
                isValidPassword = false;
            }
        }else{
            isValidPassword = false;
        }

        return isValidPassword;
    };

    public String registerUser(String username,String password){
        String message = checkUserName(username) && checkPasswordComplexity(password) ? "User Successfully Registered" : "Registration Failed. Try Again";
        return message;
    };

    public boolean loginUser(String username,String password,String storedUser,String storedPass){
        boolean login = username.equals(storedUser) && password.equals(storedPass);

        return login;
    };

    public String returnLoginStatus(boolean isLoggedIn,String firstName,String lastName){

        JOptionPane.showMessageDialog(null,isLoggedIn ? "Welcome " + firstName + " " + lastName + " it is great to see you again" : "Username or password incorrect, please try again");
        return isLoggedIn ? "Welcome " + firstName + " " + lastName + " it is great to see you again" : "Username or password incorrect, please try again";
    };


}


