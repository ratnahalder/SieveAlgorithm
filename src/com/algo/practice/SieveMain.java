package com.algo.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SieveMain {
	/**
	 * @author Ratna Halder (ratnacse06gmail.com)
	 */
	
	private int[] primeNumber;
	private boolean[] markNonPrimeNumber;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// receive user input
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int checkingValue = Integer.parseInt(br.readLine());
		
		SieveMain main = new SieveMain();
		main.sieveAlgorithm(checkingValue);
	}
	/**
	 * implementation of sieve algorithm.
	 * @param value
	 */
	private void sieveAlgorithm(int value) {
		primeNumber = new int[100000];
		markNonPrimeNumber = new boolean[1000002];
		int countPrime = 0;
		// default 1 is not a prime number
		markNonPrimeNumber[1] = true;
		// all values multiple of 2 are prime number, but, only 2 is even prime number.
		for(int i = 4; i<=value; i+=2) markNonPrimeNumber[i] = true;
		primeNumber[countPrime++] = 2; // so, first prime number is 2.
		// find prime number.
		for(int i=3; i<=value; i++){
			if(!markNonPrimeNumber[i]){
				primeNumber[countPrime++] = i;
				for(int j = i*i; j<=value; j+= i * 2){
					markNonPrimeNumber[j] = true;
				}
			}
		}
		
		// displaying all prime numbers from 0 to input value.
		for(int i = 0;i<countPrime;i++){
			System.out.println("Value= " + i + " = " + primeNumber[i]);
		}
	}
}
