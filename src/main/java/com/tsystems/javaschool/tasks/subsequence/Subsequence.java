package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */

    public boolean find(List x, List y)  {

        int identical = 0;
        int absoluteIdentical = 0;
        int index = 0;

        if (x == null || y == null) {throw new IllegalArgumentException();}

        mark: for(Object objectX: x) {
                for (int i = index; i < y.size(); i = i + 1) {
                    if (objectX == y.get(i)) {
                        identical++;
                        index = i;
                        continue mark;
                    }
                }
        }

        mark: for(Object objectX: x) {
            for (Object objectY: y) {
                if (objectX == objectY) {
                    System.out.println(objectX + " " + objectY);
                    absoluteIdentical++;
                    continue mark;
                }
            }
        }

        if (absoluteIdentical > identical) {return false;}
        if (identical < x.size()) {return false;}
        if (x.size() > y.size()) {return false;}

        return true;
    }
}
