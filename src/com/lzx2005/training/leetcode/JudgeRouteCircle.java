package com.lzx2005.training.leetcode;

/**
 * Created by Lizhengxian on 2018/2/26.
 */
public class JudgeRouteCircle {


    int[] position = {0,0};

    public boolean judgeCircle(String moves) {
        for(char c : moves.toCharArray()){
            switch (c){
                case 'U':
                    position[0]++;
                    break;
                case 'D':
                    position[0]--;
                    break;
                case 'L':
                    position[1]++;
                    break;
                case 'R':
                    position[1]--;
                    break;
                default:
            }
        }
        return position[0] == 0 && position[1] == 0;
    }
}
