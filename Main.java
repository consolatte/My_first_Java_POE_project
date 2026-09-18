import  java.util.Scanner;

     void main() {
         // Variables
         String username;
         String storedUsername;
         String storedPassword;
         String password;
         String cellphone;
         String firstname;
         String lastname;
         Scanner sc = new Scanner(System.in);
         Login userLogin = new Login();

         System.out.println("Enter your first name:");
         firstname = sc.nextLine();
         System.out.println("Enter your last name:");
         lastname = sc.nextLine();

         // Prompting the username
         System.out.println("Enter your User name:");
         username = sc.nextLine();
         //Conditions for the username
         userLogin.checkUserName(username);

         //Prompting the user for the cellphone number
         System.out.println("Please enter cell phone number:");
         cellphone =sc.nextLine();
         // conditions
         userLogin.checkCellPhoneNumber(cellphone);
         //Prompting the user for the password
         System.out.println("Please enter your password:");
         password = sc.nextLine();

         //checking the conditions for the password
         userLogin.checkPasswordComplexity(password);

         System.out.println("Registration successful");
         //Login part
         System.out.println("Please enter your login details");
         System.out.println("Username:");
         storedUsername = sc.nextLine();
         System.out.println("Password:");
         storedPassword = sc.nextLine();
         //Checking the login conditions
      userLogin.loginUser(storedUsername,storedPassword,username,password,firstname,lastname);
         System.out.println("Login successful");
     }
