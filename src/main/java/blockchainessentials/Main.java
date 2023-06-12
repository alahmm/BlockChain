package blockchainessentials;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
        System.out.print("Enter how many zeros the hash must start with:");
        Scanner scanner = new Scanner(System.in);
        int howManyZeros = scanner.nextInt();
        String hashOfThePreviousBlock = "";
        String hashOfTheBlock;
        long timeStamp;
        for (int i = 1; i < 6; i++) {
            timeStamp = new Date().getTime();

            if (i == 1) {
                hashOfThePreviousBlock = "0";
            }
            String zeros = "";
            int j = 0;
            while (j < howManyZeros) {
                zeros += 0;
                j ++;
            }
            input = input + hashOfThePreviousBlock + timeStamp;
            hashOfTheBlock = zeros + StringUtil.applySha256(input);
            hashOfTheBlock = hashOfTheBlock.substring(0, hashOfTheBlock.length() - j);
            System.out.println(BlockChain.newBlockGenerator(i, timeStamp, hashOfTheBlock, hashOfThePreviousBlock));
            hashOfThePreviousBlock = hashOfTheBlock;

            System.out.println();

        }
    }
}
class BlockChain {
    public static String newBlockGenerator (int id, long timeStamp, String hashOfTheBlock, String hashOfThePreviousBlock) {
        double time = System.nanoTime() / 1000000000.0;
        long newTime = Math.round(time);
        String str = String.format("Block:\n" +
                "Id: %d\n" +
                "Timestamp: %d\n" +
                "Magic number: %d\n" +
                "Hash of the previous block: \n" +
                "%s\n" +
                "Hash of the block: \n" +
                "%s\n" +
                "Block was generating for %d seconds", id, timeStamp, ThreadLocalRandom.current().nextLong(Long.MAX_VALUE), hashOfThePreviousBlock, hashOfTheBlock, newTime);

        return str;
    }
}