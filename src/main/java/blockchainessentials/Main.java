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
        String trans1 = """
                miner9 sent 30 VC to miner1
                miner9 sent 30 VC to miner2
                miner9 sent 30 VC to Nick""";
        String trans2 = """
                miner9 sent 10 VC to Bob
                miner7 sent 10 VC to Alice
                Nick sent 1 VC to ShoesShop
                Nick sent 2 VC to FastFood
                Nick sent 15 VC to CarShop
                miner7 sent 90 VC to CarShop""";
        String trans3 = """
                CarShop sent 10 VC to Worker1
                CarShop sent 10 VC to Worker2
                CarShop sent 10 VC to Worker3
                CarShop sent 30 VC to Director1
                CarShop sent 45 VC to CarPartsShop
                Bob sent 5 VC to GamingShop
                Alice sent 5 VC to BeautyShop""";
        String trans4 = trans3;
        String trans5 = trans3;
        String trans6 = trans3;
        String trans7 = trans3;
        String trans8 = trans3;
        String trans9 = trans3;
        String trans10 = trans3;
        String trans11 = trans3;
        String trans12 = trans3;
        String trans13 = trans3;
        String trans14 = trans3;
        String[] listOfMessages = {"No transactions", trans1, trans2, trans3, trans4, trans5,
        trans6, trans7, trans8, trans9, trans10,
        trans11, trans12, trans13, trans14};
        int N = 1;
        for (int i = 1; i < 16; i++) {
            timeStamp = new Date().getTime();

            if (i == 1) {
                hashOfThePreviousBlock = "0";

            }
            String zeros = "";
            int j = 0;
            while (j < N - 1) {
                zeros += 0;
                j++;
            }
            long magicNumber = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
            input = listOfMessages[i - 1] + hashOfThePreviousBlock + timeStamp + magicNumber;
            hashOfTheBlock = zeros + StringUtil.applySha256(input);
            hashOfTheBlock = hashOfTheBlock.substring(0, hashOfTheBlock.length() - N);

            System.out.println(BlockChain.newBlockGenerator(i, timeStamp, hashOfTheBlock,
                    hashOfThePreviousBlock, N, magicNumber, listOfMessages[i - 1]));
            if (i < 8) {
                N++;
            } else if (i >8) {
                N--;
            }

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

        int i = Integer.parseInt(String.valueOf(thread.charAt(thread.length() - 1)));
        String str = String.format("Block:\n" +
                        "Created by: miner%d\n" +
                        "miner%d gets 100 VC\n" +
                        "Id: %d\n" +
                        "Timestamp: %d\n" +
                        "Magic number: %d\n" +
                        "Hash of the previous block: \n" +
                        "%s\n" +
                        "Hash of the block: \n" +
                        "%s\n" +
                        "Block data:\n" +
                         "%s\n"+
                        "Block was generating for %d seconds",
                i,
                i,
                id, timeStamp, magicNumber, hashOfThePreviousBlock, hashOfTheBlock, message, newTime);

        if (id < 8) {
            str += String.format("\nN was increased to %d", N);
        } else if (id > 8) {
            str += "\nN was decreased by 1";

        } else {
            str += "\nN stays the same";
        }

        return str;
    }
}