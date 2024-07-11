class HillCipher{
    public static void main(String[] args) {
        String s="abcdefghi";
        int n=3;
        int q=0;
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=(int)s.charAt(q);
                q++;
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.println(mat[i][j]);
        //     }
        // }
        String t="attac";
        while (t.length()%n!=0) {
            t=t+'x';
        }
        //System.out.println(t.length()/n);
        q=0;
        int tx[][]=new int[t.length()/n][n];
        for(int i=0;i<t.length()/n;i++){
            for(int j=0;j<n;j++){
                tx[i][j]=(int)t.charAt(q);
                q++;
            }
        }
        int blockcount=0;
        String ct="";
        for(int y=0;y<t.length()/n;y++){
            for(int i=0;i<n;i++){
                for(int j=0;i<n;j++){
                    int sum=0;
                    for(int k=0;k<n;k++){
                        sum+=tx[y][k]*mat[k][j];
                    }
                    sum%=97;
                    ct+=(char)sum;
                }
            }
        }
        System.out.println(ct);
    }
}