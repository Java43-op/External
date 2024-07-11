public class andor {
    public static void main(String[] args) {
        String s="Hello world";
        char[] a=s.toCharArray();
        for(int i=0;i<s.length();i++){
            char and=(char)(s.charAt(i) & 127);
            
            char or=(char)((int)s.charAt(i) | 127);
            
            char xor=(char)(s.charAt(i) ^ 127);
            System.out.println("and: "+and+" or: "+or+" xor: "+xor);
        }
    }
}
