import java.util.Arrays;

public class railfence {
    public static void main(String[] args) {
        int k=3;
        String pt="GeeksforGeeks";
        char[][] mat=new char[k][pt.length()];
        boolean dirDown=false;
        for(int i=0;i<k;i++){
            Arrays.fill(mat[i], '\n');
        }
        int row=0,col=0;
        for(int i=0;i<pt.length();i++){
            if(row==0){
                dirDown=true;
            }
            if(row==k-1){
                dirDown=false;
            }
            mat[row][col++]=pt.charAt(i);
            if(dirDown==true){
                row++;
            }
            else{
                row--;
            }
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<k;i++){
            for(int j=0;j<pt.length();j++){
                if(mat[i][j]!='\n'){
                    s.append(mat[i][j]);
                }
            }
        }
        System.out.println(s);
        StringBuilder c=new StringBuilder();
        for(int i=0;i<pt.length();i++){
            for(int j=0;j<k;j++){
                if(mat[j][i]!='\n'){
                    c.append(mat[j][i]);
                }
            }
        }
        System.out.println(c);
    }
}
