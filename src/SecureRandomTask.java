import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomTask {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        try {
            byte[] sha256Hash = hashWithAlgorithm(bytes, "MD5");
            byte[] sha384Hash = hashWithAlgorithm(bytes, "SHA-1");
            byte[] sha512Hash = hashWithAlgorithm(bytes, "SHA-256");

            System.out.println("MD5: " + bytesToHex(sha256Hash));
            System.out.println("SHA-1: " + bytesToHex(sha384Hash));
            System.out.println("SHA-256: " + bytesToHex(sha512Hash));
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    private static byte[] hashWithAlgorithm(byte[] bytes, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        return md.digest(bytes);
    }

    static String bytesToHex(byte[] bytes) {
        StringBuilder res = new StringBuilder();
        for (byte b : bytes) {
            res.append(String.format("%02x", b));
        }
        return res.toString();
    }
}
