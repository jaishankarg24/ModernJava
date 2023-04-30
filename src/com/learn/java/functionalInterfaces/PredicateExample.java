package com.learn.java.functionalInterfaces;

import java.util.function.Predicate;

// 3
public class PredicateExample {

    static Predicate<Integer> p = (i) -> {return  i%2 == 0;};

    static Predicate<Integer> p1 = i -> i%2 ==0;

    static Predicate<Integer> p2 = (i) -> i%5 ==0;
    
    public static void predicateAnd(){

        System.out.println("Result in predicateAnd : " + p1.and(p2).test(10));
        System.out.println("Result in predicateAnd : " + p1.and(p2).test(4));
    }

    public static void predicateOr(){

        System.out.println("Result in predicateOr : " + p1.or(p2).test(4));
        System.out.println("Result in predicateOr : " + p1.or(p2).test(3));
    }

    public static void predicateNegate(){

    	// negate will reverse the result
        System.out.println("Result in predicateNegate : " + p1.and(p2).negate().test(4)); //equivalent to reversing the result
        System.out.println("Result in predicateNegate : " + p1.or(p2).negate().test(4)); 
    }
    
	public static void main(String[] args) {
		
		// 1
		System.out.println("Result is p : " + p.test(2));

		// 2
		System.out.println("Result is p1 : " + p1.test(3));
		
		// 3
		predicateAnd();
		
		// 4
		predicateOr();
		
		// 5
        predicateNegate();
	}

}
/*
Result is p : true
Result is p1 : false
Result in predicateAnd : true
Result in predicateAnd : false
Result in predicateOr : true
Result in predicateOr : false
Result in predicateNegate : true
Result in predicateNegate : false
*/