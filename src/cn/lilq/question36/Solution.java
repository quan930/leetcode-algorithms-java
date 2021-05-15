package cn.lilq.question36;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 15:43
 */
public class Solution {
    static class Block{
        int xStart;
        int xEnd;
        int yStart;
        int yEnd;

        public Block(int xStart, int xEnd, int yStart, int yEnd) {
            this.xStart = xStart;
            this.xEnd = xEnd;
            this.yStart = yStart;
            this.yEnd = yEnd;
        }

        public List<Character> getList(char[][] board){
            List<Character> list = new ArrayList<>();
            for (int i = xStart; i <= xEnd; i++) {
                for (int j = yStart; j <= yEnd; j++) {
                    list.add(board[i][j]);
                }
            }
            return list;
        }
    }
    static List<Block> blocks = new ArrayList<>();

    static {
        blocks.add(new Block(0,2,0,2));
        blocks.add(new Block(0,2,3,5));
        blocks.add(new Block(0,2,6,8));
        blocks.add(new Block(3,5,0,2));
        blocks.add(new Block(3,5,3,5));
        blocks.add(new Block(3,5,6,8));
        blocks.add(new Block(6,8,0,2));
        blocks.add(new Block(6,8,3,5));
        blocks.add(new Block(6,8,6,8));
    }

    public boolean isValidSudoku(char[][] board) {
        if (!checkLine(board))
            return false;
        if (!checkLow(board))
            return false;
        return checkBlock(board);
    }

    private boolean checkBlock(char[][] board) {
        List<List<Character>> lists = new ArrayList<>();
        blocks.forEach(block -> {
            lists.add(block.getList(board));
        });
        return check(lists);
    }

    private boolean checkLow(char[][] board) {
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                list.add(board[j][i]);
            }
            lists.add(list);
        }
        return check(lists);
    }

    private boolean checkLine(char[][] board) {
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                list.add(board[i][j]);
            }
            lists.add(list);
        }
        return check(lists);
    }

    private boolean check(List<List<Character>> lists){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            map.clear();
            for (int j = 0; j < 9; j++) {
                Character character = lists.get(i).get(j);
                if (character!='.' && map.get(character)!=null)
                    return false;
                map.put(character,1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'.');
    }
}
