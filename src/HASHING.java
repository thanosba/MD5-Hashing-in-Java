import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HASHING {

    private final static String pattern="DGE$5S-Gr@3VsHY=UM+as2323E4d5<)7vfBfFSTR?U@!DSH(*%FDSdfg13sgfsg";

    public static void main(String[] args) {
        String password = "ThanosBalanikas89";
        String empty =  null;
        String msg = "This is a text message.";
        System.out.println(password+" MD5 hashed to>>>>>>> " + md5Hash(password));
        System.out.println(empty+" MD5 hashed to>>>>>>> " + md5Hash(null));
        System.out.println(msg+" MD5 hashed to>>>>>>> " + md5Hash(msg));
    }

    //Takes a string, and converts it to md5 hashed string.
    public static String md5Hash(String message) {
        String md5 = "";
        if(null == message)
            return null;
        message = message+pattern;//adding a salt to the string before it gets hashed.
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");//Create MessageDigest object for MD5
            digest.update(message.getBytes(), 0, message.length());//Update input string in message digest
            md5 = new BigInteger(1, digest.digest()).toString(16);//Converts message digest value in base 16 (hex)

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
