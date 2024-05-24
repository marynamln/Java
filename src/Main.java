import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "Maryna Melnyk";

        System.out.println("=========== Task 1 ===========");

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

        System.out.println("=========== Task 2 ===========");

        try {
            System.out.println("SHA1PRNG: " + hashWithSecureRandom(str, "SHA1PRNG"));
            System.out.println("DRBG: " + hashWithSecureRandom(str, "DRBG"));
            System.out.println("Windows-PRNG: " + hashWithSecureRandom(str, "Windows-PRNG"));
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        System.out.println("=========== Task 3 ===========");

        HashMap<StudentCorrect, Integer> mapCorrect = new HashMap<>();

        StudentCorrect st1 = new StudentCorrect("Maryna", 2);
        StudentCorrect st2 = new StudentCorrect("Iryna", 1);
        StudentCorrect st3 = new StudentCorrect("Maryna", 2);

        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
        System.out.println(st3.hashCode());

        System.out.println(st1.equals(st2));
        System.out.println(st1.equals(st3));

        mapCorrect.put(st1, 1);
        mapCorrect.put(st2, 2);
        mapCorrect.put(st3, 3);

        for(Map.Entry<StudentCorrect, Integer> entry : mapCorrect.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        System.out.println(mapCorrect.get(st1));

        System.out.println();

        HashMap<StudentIncorrect, Integer> mapIncorrect = new HashMap<>();

        StudentIncorrect st4 = new StudentIncorrect("Roman", 3);
        StudentIncorrect st5 = new StudentIncorrect("Olga", 1);
        StudentIncorrect st6 = new StudentIncorrect("Roman", 3);

        System.out.println(st4.hashCode());
        System.out.println(st5.hashCode());
        System.out.println(st6.hashCode());

        System.out.println(st4.equals(st5));
        System.out.println(st4.equals(st6));

        mapIncorrect.put(st4, 1);
        mapIncorrect.put(st5, 2);
        mapIncorrect.put(st6, 3);

        for(Map.Entry<StudentIncorrect, Integer> entry : mapIncorrect.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        System.out.println(mapIncorrect.get(st6));
    }

    public static String hashWithSecureRandom(String str, String algorithm) throws NoSuchAlgorithmException {
        SecureRandom instance = SecureRandom.getInstance(algorithm);
        byte bytes[] = new byte[16];
        instance.setSeed(str.getBytes());
        instance.nextBytes(bytes);
        return bytesToHex(bytes);
    }

    static String bytesToHex(byte[] bytes) {
        StringBuilder res = new StringBuilder();
        for (byte b : bytes) {
            res.append(String.format("%02x", b));
        }
        return res.toString();
    }
}
