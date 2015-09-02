package com.algo.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AllDivisors {
	/**
	 * @author Ratna Halder (ratnacse06gmail.com)
	 */
	
	private int[] divisors[];
	private int[] count;

	public static void main(String[] args) throws IOException {
		//Receive user input.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value = Integer.valueOf(br.readLine());
		
		AllDivisors div = new AllDivisors();
		div.findAllDivisors(value);
	}
	
	private void findAllDivisors(int value){
		// Initialize all variables.
		count = new int[1000002];
		divisors = new int[1000002][300];

		// find all divisor of all digit from 0 to value.
		for(int i = 1; i<= value; i++){
			for(int j = i; j<=value; j+=i){
				count[j] +=1;
				divisors[j][count[j]] = i;
			}
		}
		
		// Showing all divisors
		for(int i = 1; i<divisors.length; i++){
			for(int j = 1; j<=count[i]; j++){
				System.out.println("Value= " + i + " = " + divisors[i][j]);
			}
		}
	}
}
