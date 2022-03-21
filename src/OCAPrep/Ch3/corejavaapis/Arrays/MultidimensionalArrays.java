package OCAPrep.Ch3.Arrays;

import OCAPrep.Ch3.CreatingAndManipulatingStrings.Main;

/*
AKA matrices
index in first bracket determines the row, the second determines the column
 */
public class MultidimensionalArrays {
        public static void main(Main[] args) {
            test();
        }

        public static void test() {
            int[][] vars1;              //2D array
            int vars2 [][];             //2D array
            int[] vars3 [];             //2D array
            int[] vars4 [], space [][]; //2D and 3D array
            Main[][] rectangle = new Main[3][2];
//            rectangle[0][1] = "set";    //places "set" in the second row, of the first column
            int[][] lotteryCard = {{20, 11, 9}, {5, 25, 11}, {95, 65, 33}};

            System.out.println(lotteryCard[1][1]);
            System.out.println(lotteryCard[2][2]);
            System.out.println(lotteryCard[2][0]);
        }
}
