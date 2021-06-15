package cn.lilq.question68;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/15 15:50
 */
public class Solution {
    /**
     * 生成空格
     * @param spaceSize
     * @return
     */
    private String space(int spaceSize){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < spaceSize; i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    /**
     * 中间行
     * @param res
     * @param temp
     * @param tempSize
     * @param maxWidth
     */
    private void util(List<String> res,List<String> temp,int tempSize,int maxWidth){
        //todo 初始化
        StringBuilder stringBuilder = new StringBuilder();
        //todo 大小为1
        if (temp.size()==1){
            stringBuilder.append(temp.get(0));
            stringBuilder.append(space(maxWidth-tempSize));
            res.add(stringBuilder.toString());
            return;
        }
        //todo 大小为2
        if (temp.size()==2){
            stringBuilder.append(temp.get(0));
            stringBuilder.append(space(maxWidth-tempSize));
            stringBuilder.append(temp.get(1));
            res.add(stringBuilder.toString());
            return;
        }
        //todo 大小大于2
        int space = (maxWidth-tempSize)/(temp.size()-1);
        int spaceMod = (maxWidth-tempSize)%(temp.size()-1);
        String spaceS = space(space);
        for (int i = 0; i < temp.size()-1; i++) {
            stringBuilder.append(temp.get(i));
            stringBuilder.append(spaceS);
            if (spaceMod>0){
                stringBuilder.append(' ');
                spaceMod--;
            }
        }
        stringBuilder.append(temp.get(temp.size()-1));
        res.add(stringBuilder.toString());
    }

    private void lastLine(List<String> res,List<String> temp,int maxWidth){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < temp.size()-1; i++) {
            stringBuilder.append(temp.get(i));
            stringBuilder.append(' ');
        }
        stringBuilder.append(temp.get(temp.size()-1));
        stringBuilder.append(space(maxWidth-stringBuilder.length()));
        res.add(stringBuilder.toString());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> temp = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int tempSize = 0;
        for (int i = 0; i < words.length; i++) {
            if ((tempSize+words[i].length()+temp.size())>maxWidth){
                util(res,temp,tempSize,maxWidth);
                temp.clear();
                tempSize=0;
                i--;
            }else {
                temp.add(words[i]);
                tempSize += words[i].length();
            }
        }
        //todo 最后一行
        lastLine(res,temp,maxWidth);
        return res;
    }
}