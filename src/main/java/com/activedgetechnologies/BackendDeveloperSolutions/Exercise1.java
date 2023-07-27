package com.activedgetechnologies.BackendDeveloperSolutions;

import java.util.HashSet;
public class Exercise1 {
    public static int findSmallestNonOccurring(int[] arr) {
        HashSet<Integer> positiveNumbers = new HashSet<>();

        // Collect positive integers into the HashSet
        for (int num : arr) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        // Find the smallest non-occurring integer starting from 1
        int smallestNonOccurring = 1;
        while (positiveNumbers.contains(smallestNonOccurring)) {
            smallestNonOccurring++;
        }

        return smallestNonOccurring;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};
        int [] array3 = {9, 0, 4, 6, 2, 9, 3, 1};
        int [] array4 = {-9, 0, -4, -6, 2,5, 9, -3, 1};


        int result1 = findSmallestNonOccurring(array1);
        int result2 = findSmallestNonOccurring(array2);
        int result3 = findSmallestNonOccurring(array3);
        int result4 = findSmallestNonOccurring(array4);



        System.out.println("Smallest non-occurring integer in Array1: " + result1); // Output: 5
        System.out.println("Smallest non-occurring integer in Array2: " + result2); // Output: 1
        System.out.println("Smallest non-occurring integer in Array3: " + result3); // Output: 5
        System.out.println("Smallest non-occurring integer in Array3: " + result4); // Output: 3


    }

//    public static int findSmallestNonOccurringInteger(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        int smallestNonOccurring = 1;
//        while (set.contains(smallestNonOccurring)) {
//            smallestNonOccurring++;
//        }
//
//        return smallestNonOccurring;
//    }


}



