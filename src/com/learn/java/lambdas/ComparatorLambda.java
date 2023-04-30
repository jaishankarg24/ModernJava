package com.learn.java.lambdas;

import java.util.Comparator;

// 1
public class ComparatorLambda {

	public static void main(String[] args) {
		// shortcut - search everywhere classes - ctrl+shift+T (Runnable)
		
        /**
         * Prior JAVA 8
         */
		// 1
        Comparator<Integer> comparator  = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> if both are equal
                                        // 1 -> if o1 > o2
                                        //-1 -> if o1 < o2
            }
        };

        System.out.println(comparator.compare(1,2)); // -1
		
        // 2
        /**
         * In JAVA 8
         */
        Comparator<Integer> comparatorLambda = (Integer  a,Integer b) -> a.compareTo(b);
        Comparator<Integer> comparatorLambda1 = (a,b) -> a.compareTo(b);

        System.out.println(comparatorLambda.compare(1,2)); // -1
        System.out.println(comparatorLambda1.compare(2,2)); // 0
        
        // 3
        System.out.println("The greatest integer is : " + compareTwoIntegers(comparatorLambda,1,2));
        
        // 4
        /**
         * Comparator chaining happens only when the first comparators result is zero.
         */
        System.out.println("Result of chaining comparator is with equal inputs : " + comparatorLambda1.thenComparing(comparatorLambda1).compare(2,2));

        System.out.println("Result of chaining comparator is with not equal inputs: " + comparatorLambda1.thenComparing(comparatorLambda1).compare(3,2));
	}
	
	//3
    public static int compareTwoIntegers(Comparator<Integer> comparator, int a, int b){

        return comparator.compare(a,b);
    }

}
