package Ext;

public class Program_6_ColumnarTransposition {
    public static void main(String[] args) {
        int col = 4;
        String pt = "javaprogrammingx";
        int[] key = { 2, 3, 0, 1 };
        char[][] mat = new char[pt.length() / col][col];
        int cnt = 0;
        for (int i = 0; i < pt.length() / col; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = pt.charAt(cnt);
                cnt++;
            }
        }
        StringBuilder ct = new StringBuilder();
        int kind = 0;
        for (int i; kind < col; kind++) {
            i = key[kind];
            for (int j = 0; j < pt.length() / col; j++) {
                ct.append(mat[j][i]);
            }
        }
        System.out.println(ct);
        kind = 0;
        cnt = 0;
        char[][] newmat = new char[pt.length() / col][col];
        for (int i; kind < col; kind++) {
            i = key[kind];
            for (int j = 0; j < pt.length() / col; j++) {
                newmat[j][i] = ct.charAt(cnt);
                cnt++;
            }
        }
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < pt.length() / col; j++) {
                t.append(newmat[i][j]);
            }
        }
        System.out.println(t);
    }
}