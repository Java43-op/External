package Ext;

public class Program_6_ColumnarTransposition {
    public static void main(String[] args) {
        int col = 4;
        String pt = "javaprogrammingx";
        int[] key = { 2, 3, 0, 1 };
        int row = pt.length() / col;
        char[][] mat = new char[row][col];
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = pt.charAt(cnt);
                cnt++;
            }
        }
        StringBuilder ct = new StringBuilder();
        int kind = 0;
        for (int i; kind < col; kind++) {
            i = key[kind];
            for (int j = 0; j < row; j++) {
                ct.append(mat[j][i]);
            }
        }
        System.out.println(ct);
        kind = 0;
        cnt = 0;
        char[][] newmat = new char[row][col];
        for (int i; kind < col; kind++) {
            i = key[kind];
            for (int j = 0; j < row; j++) {
                newmat[j][i] = ct.charAt(cnt);
                cnt++;
            }
        }
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                t.append(newmat[i][j]);
            }
        }
        System.out.println(t);
    }
}
