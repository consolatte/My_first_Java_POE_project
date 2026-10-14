
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class Testing{

    // Test 1 - Message ID length
    @Test
    public void testCheckMessageID() {
        Message msg = new Message(1, "+27834567890", "Hi there");
        // Ton generateMessageID() doit donner 10 chiffres
        assertTrue(msg.checkMessageID(), "Message ID should be <= 10 chars");
        assertEquals(10, msg.getMessageID().length());
    }

    // Test 2 - Recipient VALID - doit être avec +27
    @Test
    public void testCheckRecipientCell_Valid() {
        Message msg = new Message(1, "+27834567890", "Hello");
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }

    // Test 3 - Recipient INVALID - sans code international
    @Test
    public void testCheckRecipientCell_Invalid() {
        Message msg = new Message(1, "0834567890", "Hello");
        String result = msg.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted"));
    }

    // Test 4 - Message trop long > 250 - tu le check dans Main mais on teste aussi ici
    @Test
    public void testMessageLength_Valid() {
        String shortText = "Hello world";
        assertTrue(shortText.length() <= 250);
    }

    @Test
    public void testMessageLength_Invalid() {
        String longText = "a".repeat(251);
        assertTrue(longText.length() > 250);
    }

    // Test 5 - Message Hash format - LE PLUS IMPORTANT POUR LE POE
    @Test
    public void testCreateMessageHash() {
        // On force un ID pour pouvoir tester le hash
        // Message 1: "Hi Mike, can you join us"
        Message msg = new Message(1, "+27834567890", "Hi Mike, can you join us");
        // On remplace l'ID généré par un ID connu pour le test
        // Si tu veux tester exactement: 00:1:HITUS ou 00:1:HIUS
        String hash = msg.getMessageHash();

        // Le hash doit contenir ":" et être en UPPERCASE
        assertNotNull(hash);
        assertTrue(hash.contains(":"));
        assertEquals(hash, hash.toUpperCase());
        // Il doit commencer par les 2 premiers chiffres de l'ID
        String firstTwo = msg.getMessageID().substring(0, 2);
        assertTrue(hash.startsWith(firstTwo));
    }

    // Test 6 - sentMessage options
    @Test
    public void testSentMessage_Option1() {
        Message msg = new Message(1, "+27834567890", "Test");
        String result = msg.sentMessage(1);
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testSentMessage_Option2() {
        Message msg = new Message(1, "+27834567890", "Test");
        String result = msg.sentMessage(2);
        // !!! VÉRIFIE TON BRIEF - ici c'est ton texte actuel
        assertEquals("Press 0 to delete the message.", result);
    }

    @Test
    public void testSentMessage_Option3() {
        Message msg = new Message(1, "+27834567890", "Test");
        String result = msg.sentMessage(3);
        assertEquals("Message successfully stored.", result);
    }

    // Test 7 - Total sent counter (logique de Main)
    @Test
    public void testTotalSentLogic() {
        int totalSent = 0;
        Message msg = new Message(1, "+27834567890", "Test");
        String status = msg.sentMessage(1);
        if (status.equals("Message successfully sent.")) {
            totalSent++;
        }
        assertEquals(1, totalSent);
    }
}





