import javax.crypto.*;
import java.util.*;

public class des {
    public static void main(String[] args) throws Exception {
        SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String s = "java";
        byte[] enbytes = cipher.doFinal(s.getBytes());
        String ens = Base64.getEncoder().encodeToString(enbytes);
        System.out.println(ens);
        Cipher dCipher = Cipher.getInstance("DES");
        dCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] dbytes = dCipher.doFinal(Base64.getDecoder().decode(ens));
        System.out.println(new String(dbytes));
    }
}
