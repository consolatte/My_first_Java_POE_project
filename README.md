PROG5121 POE - QuickChat

student Name: Consolatte  
Module: Programming 1A (PROG5121)  
Project: QuickChat Messaging System - Part 1 & 2

# Project Description
QuickChat is a Java console application that allows users to register, login, and send quick messages. This project was built in two parts.

*Part 1: User registration system with validation
- Username must contain underscore (_) and be <= 5 characters
- Password must be >= 8 characters, contain capital letter, number, and special character
- Cellphone number must start with +27 and be 12 characters

*Part 2:Messaging system (QuickChat)
- Generate 10-digit random Message ID
- Validate recipient cell number (must contain +27 international code)
- Validate message length <= 250 characters
- Create Message Hash (first 2 of ID : messageNumber : firstWord + lastWord) - UPPERCASE
- Options: Send, Disregard (delete), Store for later
- Counter for total messages sent/stored

# Features
- User Registration and Login
- Secure Password Complexity Check
- International Cell Number Validation
- Random Message ID Generator
- Message Hash Creator
- Message Sending Management
- JUnit 5 Unit Testing (10 tests)

# Technologies Used
- Java JDK 17+
- IntelliJ IDEA
- JUnit 5 (org.junit.jupiter.api)
- Random class for ID generation

# Project Structure
QuickChat/
├── Main.java       -> Main program, user interaction, menu loop
├── Login.java      -> Registration logic: checkUserName, checkPassword, checkCellPhone
├── Message.java    -> Messaging logic: ID, recipient check, hash, sentMessage
├── Testing.java    -> JUnit tests (10 tests for Message class)
└── README.md       -> This file

**How to Run**

1.Open in IntelliJ
Open the project folder in IntelliJ IDEA.

2.Compile
javac http://Main.java http://Login.java http://Message.java

3.Run Main
java Main

4.Run Tests
Right-click on http://Testing.java -> Run 'Testing'

**How to Use the App**

1.Registration:
   - Enter first name, last name
   - Enter username e.g. kyl_1
   - Enter cellphone e.g. +27834567890
   - Enter password e.g. Ch$$sec@ke99!

2.Login:
   - Login with registered username and password

3.QuickChat:
   - Enter how many messages you want to send (e.g. 2)
   - For each message:
     - Enter recipient: +27834567890
     - Enter message text: Hi Mike, can you join us
     - Choose option: 1 = Send, 2 = Disregard, 3 = Store

**Unit Tests Included (10 Tests)**
testCheckMessageID - Checks Message ID length = 10
testCheckRecipientCell_Valid - Valid +27 number
testCheckRecipientCell_Invalid - Invalid number
testMessageLength_Valid - Text <=250
testMessageLength_Invalid - Text >250
testCreateMessageHash - Hash contains :, UPPERCASE
testSentMessage_Option1 - Option 1 returns "Message successfully sent."
testSentMessage_Option2 - Option 2 returns "Press 0 to delete the message."
testSentMessage_Option3 - Option 3 returns "Message successfully stored."
testTotalSentLogic - Counts total sent

**Example Output**
Welcome to QuickChat.
Message ID: 3568611284
Message Hash: 12:1:HITHERE
Recipient: +27834567890
Message: Hi there
Message successfully sent.
Total messages sent/stored: 1

#Author
Consolatte - IIE Rosebank internationnal

#References
IIE PROG5121 POE Part 2 Specification
JUnit 5 Documentation

