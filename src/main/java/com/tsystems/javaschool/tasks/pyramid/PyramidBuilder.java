package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        // TODO : Implement your solution here
        return new int[0][0];
    }

//    int floors = 0; //number of floors of pyramide
//    boolean canBuild = false;
//    int numberOfBlocks = 0;//number of pyramide blocks (numbers)
//    int step = 1;
//    int width;
//    int height;
//
//    public int[][] buildPyramid(List<Integer> inputNumbers) throws CannotBuildPyramidException {
//        if(inputNumbers.size()>100){
//            throw new CannotBuildPyramidException("too big");
//        }
//        else {
//            if (inputNumbers.contains(null)) {
//                throw new CannotBuildPyramidException("null element");
//            } else {
//                Collections.sort(inputNumbers);
//            }
//        }
//        for (int x : inputNumbers) {
//            numberOfBlocks = numberOfBlocks + step;
//            floors++;
//            if (numberOfBlocks == inputNumbers.size()) {
//                canBuild = true;
//                break;
//            }
//            step++;
//        }
//
//        int[][] intArray;
//        if (canBuild == true) {
//            height = floors;
//            width = floors * 2 - 1;
//            int k = inputNumbers.size() - 1;
//
//
//            intArray = new int[height][width];
//            for (int y = height - 1; y >= 0; y--) {
//                int counter = (height - 1) - y;
//                int numberOfZeros = counter;
//                for (int z = width - 1; z >= 0; z--) {
//                    if ((z == width - 1 - counter) && (z >= numberOfZeros)) {
//                        intArray[y][z] = inputNumbers.get(k);
//                        k--;
//                        counter = counter + 2;
//                    }
//                }
//            }
//        } else {
//            throw new CannotBuildPyramidException("cannot build pyramid");
//        }
//        return intArray;
//    }


}
