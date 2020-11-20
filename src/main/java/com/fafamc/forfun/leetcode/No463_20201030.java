package com.fafamc.forfun.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/island-perimeter/
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *  输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class No463_20201030 {
    public int islandPerimeter(int[][] grid) {
        //正方形数量
        int nums = (int)Stream.of(grid).flatMapToInt(x -> Arrays.stream(x))
                .filter(a -> a==1)
                .count();
        //相邻的横线
        int h_ = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length -1 ; j++){
                if(grid[i][j] == grid[i][j+1] && grid[i][j] == 1){
                    h_++;
                }
            }
        }
        //相邻的竖线
        int s_ = 0;
        for(int i = 0 ; i < grid.length - 1 ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == grid[i+1][j] && grid[i][j] == 1){
                    s_++;
                }
            }
        }
        return 4*nums - 2*h_ - 2*s_;
    }


    public static void main(String[] args) {
        int grid[][] = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        No463_20201030 todo = new No463_20201030();
        System.out.println(todo.islandPerimeter(grid));
    }
}
