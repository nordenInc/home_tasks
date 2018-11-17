package com.tsystems.javaschool.tasks.subsequence;

import java.util.Arrays;

public class SubsequenceImpl extends Subsequence {

    public static void main(String[] args) {
        Subsequence subsequence = new SubsequenceImpl();
        System.out.println(subsequence.find(Arrays.asList("A", "B", "C", "D"),Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D")));
    }

}
