package org.example.sorter.util;

import org.example.model.Student;

public class SortedUtil {

    public static Student[] mergeSort(Student[] source, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(source, left, mid);
            mergeSort(source, mid + 1, right);

            merge(source, left, mid, right);
        }
        return source;
    }

    private static void merge(Student[] source, int left, int mid, int right) {
        Student[] temp = new Student[right - left + 1];

        int j = mid + 1;
        int k = 0;

        while (left <= mid && j <= right) {
            if (source[left].compareTo(source[j]) <= 0) {
                temp[k++] = source[left++];
            } else {
                temp[k++] = source[j++];
            }
        }

        while (left <= mid) {
            temp[k++] = source[left++];
        }

        while (j <= right) {
            temp[k++] = source[j++];
        }

        System.arraycopy(temp, 0, source, left, temp.length);
    }
}
