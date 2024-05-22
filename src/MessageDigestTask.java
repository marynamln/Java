import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class MessageDigestTask {
    public static void main(String[] args) {
        String str = "Maryna Melnyk";

        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md5.digest(str.getBytes());
            System.out.println("MD5: " + bytesToHex(md5Hash));

            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = sha1.digest(str.getBytes());
            System.out.println("SHA-1: " + bytesToHex(sha1Hash));

            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] sha256Hash = sha256.digest(str.getBytes());
            System.out.println("SHA-256: " + bytesToHex(sha256Hash));
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    static String bytesToHex(byte[] bytes) {
        StringBuilder res = new StringBuilder();
        for (byte b : bytes) {
            res.append(String.format("%02x", b));
        }
        return res.toString();
    }
}
