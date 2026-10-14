import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Variables from Part 1
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
        // Conditions for the username

        userLogin.checkUserName(username);

        // Prompting the user for the cellphone number
        System.out.println("Please enter cell phone number:");
        cellphone = sc.nextLine();
        // Prompting the user for the password
        System.out.println("Please enter your password:");
        password = sc.nextLine();

        // Checking the conditions for the password
        userLogin.checkPasswordComplexity(password);
        System.out.println("Registration successful");

        // Login part
        System.out.println("Please enter your login details");
        System.out.println("Username:");
        storedUsername = sc.nextLine();
        System.out.println("Password:");
        storedPassword = sc.nextLine();

        // Checking the login condition
        String loginResult = userLogin.loginUser(storedUsername, storedPassword, username, password, firstname, lastname);
        System.out.println(loginResult);

        // PART 2 - QuickChat (Added)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to QuickChat.");

        // Simplified login for Part 2 demonstration (Assuming registered from Part 1)
        System.out.println("Please log in.");
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        // Dummy validation for Part 2 demonstration
        if (!user.equals("kyl_1") || !pass.equals("Ch&sec@ke99!")) {
            System.out.println("Login failed. Exiting.");
            return;
        }

        System.out.print("How many messages do you wish to send ? ");
        int numMessages = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        int totalSent = 0;

        for (int i = 1; i <= numMessages; i++) {
            System.out.println("\n--- Message " + i + " ---");
            System.out.print("Enter recipient cell number: ");
            String recipient = scanner.nextLine();

            System.out.print("Enter message (max 250 characters): ");
            String text = scanner.nextLine();

            if (text.length() > 250) {
                System.out.println("Please enter a message of less than 250 characters.");
                i--; // Retry this message
                continue;
            }

            Message msg = new Message(i, recipient, text);
            String check = msg.checkRecipientCell();
            System.out.println(check);
            if (check.contains("incorrectly formatted")) {
                i--;
                continue;
            }


            // Display details
            System.out.println("Message ID: " + msg.getMessageID());
            System.out.println("Message Hash: " + msg.getMessageHash());
            System.out.println("Recipient: " + msg.getRecipient());
            System.out.println("Message: " + msg.getMessageText());

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String status = msg.sentMessage(choice);
            System.out.println(status);

            if (choice == 1) {
                totalSent++;
            }
        }

        System.out.println("\nTotal messages sent: " + totalSent);
        System.out.println("Exiting QuickChat.");
        scanner.close();


    }
}

