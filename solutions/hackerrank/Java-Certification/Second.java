package problems.hackerrank.Java-Certification;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static Integer sum(Integer[] ints) {
        int sum = 0;
        for (int num : ints) {
            sum += num;
        }
        return sum;
    }

    public static String sum(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String[] inputs = inputLine.split(" ");

        Integer[] intArray = new Integer[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            intArray[i] = Integer.parseInt(inputs[i]);
        }

        System.out.println(sum(intArray));

        scanner.close();
    }
}


public class Second {
    
}

/* only 8 out of 15 tests passed. I'm moving on because of time. I'll to come back later to fix it*/