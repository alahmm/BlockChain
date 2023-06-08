package blockchainessentials;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Scanner;

public class Main {
}

class StringUtil {
    public static String input;
    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String hashOfThePreviousBlock = "";
        String hashOfTheBlock;
        long timeStamp;
        for (int i = 1; i < 6; i++) {
            timeStamp = new Date().getTime();

            if (i == 1) {
                hashOfThePreviousBlock = "0";
            }
            input = input + hashOfThePreviousBlock + timeStamp;
            hashOfTheBlock = StringUtil.applySha256(input);
            System.out.println(BlockChain.newBlockGenerator(i, timeStamp, hashOfTheBlock, hashOfThePreviousBlock));
            hashOfThePreviousBlock = hashOfTheBlock;

            System.out.println();

        }
    }
}
class BlockChain {
    public static String newBlockGenerator (int id, long timeStamp, String hashOfTheBlock, String hashOfThePreviousBlock) {
        String str = String.format("Block:\n" +
                "Id: %d\n" +
                "Timestamp: %d\n" +
                "Hash of the previous block: \n" +
                "%s\n" +
                "Hash of the block: \n" +
                "%s", id, timeStamp, hashOfThePreviousBlock, hashOfTheBlock);

        return str;
    }
}