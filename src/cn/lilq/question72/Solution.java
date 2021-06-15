package cn.lilq.question72;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/1 20:20
 * 动态规划
 */
public class Solution {
    private void print(int[][] res){
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int minDistance(String word1, String word2) {
        int[][] res=new int[word1.length()+1][word2.length()+1];
        res[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            res[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            res[0][i] = i;
        }
//        print(res);
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    res[i][j] = res[i-1][j-1];
                }else {
                    res[i][j] = Math.min(Math.min(res[i][j-1],res[i-1][j]),res[i-1][j-1])+1;
                }
            }
        }
        print(res);
        return res[word1.length()][word2.length()];
    }
}