public class additive {
    public static void main(String[] args) {
        int n=3;
        String pt1="hellozz";
        char[] pt=pt1.toCharArray();
        char[] ct=new char[pt.length];
        for(int i=0;i<pt.length;i++){
            if(n+pt[i]>122){
                ct[i]=(char)(96+(n+pt[i]-122));
            }
            else{
                ct[i]=(char)(n+pt[i]);
            }
        }
        System.out.println(new String(ct));
        for(int i=0;i<ct.length;i++){
            if(ct[i]-n<97){
                pt[i]=(char)(26+(ct[i]-n));
            }
            else{
                pt[i]=(char)(ct[i]-n);
            }
        }
        System.out.println(new String(pt));
    }
}
