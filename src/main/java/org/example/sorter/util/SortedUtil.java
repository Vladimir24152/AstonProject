package org.example.sorter.util;

import org.example.model.Student;

public class SortedUtil {

    public static Student[] mergeSort(Student[] source, int left, int right) {

        int delimiter = left + ((right - left) / 2) + 1;

        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }

        Student[] buffer = new Student[right - left + 1];

        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {

            if (delimiter > right || source[cursor].compareTo(source[delimiter]) < 0) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
        return source;
    }
}
