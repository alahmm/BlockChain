package blockchainessentials;

import java.security.MessageDigest;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

class StringUtil {
    public static String input;

    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String hashOfThePreviousBlock = "";
        String hashOfTheBlock;
        long timeStamp;
        String messageLong = """
                Sarah: It's not fair!
                Sarah: You always will be first because it is your blockchain!
                Sarah: Anyway, thank you for this amazing chat.""";
        String[] listOfMessages = {"no messages", "no messages", "Tom: Hey, I'm first!", messageLong, "Tom: You're welcome :)"};
        int N = 0;
        for (int i = 1; i < 6; i++) {
            timeStamp = new Date().getTime();

            if (i == 1) {
                hashOfThePreviousBlock = "0";

            }
            String zeros = "";
            int j = 0;
            while (j < N) {
                zeros += 0;
                j++;
            }
            long magicNumber = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
            input = input + hashOfThePreviousBlock + timeStamp + magicNumber;
            hashOfTheBlock = zeros + StringUtil.applySha256(input);
            hashOfTheBlock = hashOfTheBlock.substring(0, hashOfTheBlock.length() - N);


            if (i < 3) {
                N++;
            } else if (i > 3) {
                N--;
            }

            System.out.println(BlockChain.newBlockGenerator(i, timeStamp, hashOfTheBlock,
                    hashOfThePreviousBlock, N, magicNumber, listOfMessages[i - 1]));

            hashOfThePreviousBlock = hashOfTheBlock;

            System.out.println();

        }
    }
}

class BlockChain {
    public static String newBlockGenerator(int id, long timeStamp, String hashOfTheBlock, String hashOfThePreviousBlock,
                                           int N, long magicNumber, String message) {
        double time = System.nanoTime() / 1000000000.0;
        long newTime = Math.round(time);
        String thread = new Thread().getName();

        String str = String.format("Block:\n" +
                        "Created by miner # %d\n" +
                        "Id: %d\n" +
                        "Timestamp: %d\n" +
                        "Magic number: %d\n" +
                        "Hash of the previous block: \n" +
                        "%s\n" +
                        "Hash of the block: \n" +
                        "%s\n" +
                        "Block data:\n" +
                         "%s\n"+
                        "Block was generating for %d seconds", Integer.parseInt(String.valueOf(thread.charAt(thread.length() - 1))),
                id, timeStamp, magicNumber, hashOfThePreviousBlock, hashOfTheBlock, message, newTime);

        if (id < 3) {
            str += String.format("\nN was increased to %d", N);
        } else if (id > 3) {
            str += "\nN was decreased by 1";

        } else {
            str += "\nN stays the same";
        }

        return str;
    }
}