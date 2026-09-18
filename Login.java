import java.util.Scanner;

public class Login {
    String username;
    String cellphone;
    String password;
    String storedUsername;
    String storedPassword;
    String firstname;
    String lastname;


    Scanner sc = new Scanner(System.in);
    void checkUserName(String username){
    while (true) {
        if (username.length() <= 6 && username.contains("_")) {
            System.out.println("username successfully captured.");
            break;
        } else {
            System.out.println("Username is not correctly formated ; please ensure that your username contains an underscore and is no more than 5 character in length ");
            username = sc.nextLine();
        }
    }
}
void checkCellPhoneNumber(String cellphone){
    while (true){
        if (cellphone.startsWith("+27") && cellphone.length()<=12){
            System.out.println("Cellphone successfully captured ");
            break;
        } else {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code");
            cellphone =sc.nextLine();
        }
    }
}
void checkPasswordComplexity(String password){
    while(true){
        boolean hasCapital= false;
        boolean hasNumber = false ;
        boolean hasSpecial = false ;
        for (int i = 0 ; i<password.length();i++){
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)){
                hasCapital = true ;
            }
            if (Character.isDigit(ch)){
                hasNumber = true ;
            }
            if (!Character.isLetterOrDigit(ch)){
                hasSpecial = true;
            }
        }
        if (password.length()>= 8 && hasCapital && hasNumber && hasSpecial){
            System.out.println("Password successfully captured");
            break;
        } else {
            System.out.println("Password is not correctly formatted , please ensure that your password contains at least eight character , a capital letter , a number , and a special character");
            password = sc.nextLine();

        }
    }
}
void loginUser(String storedUsername ,String storedPassword ,String username , String password,String firstname ,String lastname){
    while(true){
        if (storedUsername.matches(username)&&storedPassword.matches(password)){
            System.out.println("Welcome "+firstname+" "+ lastname+" It is great to see you again!");
            break;
        } else {
            System.out.println("Username or password incorrect ,please try again");
            storedUsername = sc.nextLine();
            storedPassword = sc.nextLine();
        }
    }
}
}
