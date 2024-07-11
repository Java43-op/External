import java.math.BigInteger;
import java.security.MessageDigest;

public class sha {
    public static void main(String[] args) throws Exception{
        String s="retard";
        MessageDigest md=MessageDigest.getInstance("SHA-1");
        byte[] enbytes=md.digest(s.getBytes());
        BigInteger bi=new BigInteger(enbytes);
        System.out.println(bi.toString(16));
    }
}
