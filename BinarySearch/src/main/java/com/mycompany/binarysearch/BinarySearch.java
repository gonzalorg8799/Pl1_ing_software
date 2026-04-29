/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.binarysearch;

/**
 *
 * @author skali
 */
public class BinarySearch {
    //pueblic static void main(Strings [] args){}
    public static int binarySearch(int[] A, int x) {
// search space is `A[left…right]`
        int left = 0, right = A.length - 1;
// loop till the search space is exhausted
        while (left <= right) {
// find the mid-value in the search space and
// compares it with the target
            int mid = (left + right) / 2;
// key is found
            if (x == A[mid]) {
                return mid;
            } // discard all elements in the right search space,
            // including the middle element
            else if (x < A[mid]) {
                right = mid - 1;
            } // discard all elements in the left search space,
            // including the middle element
            else {
                left = mid + 1;
            }
        }
// `x` doesn't exist in the array
        return -1;
    }
}
