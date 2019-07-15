/**
 * 
 */
package com.pram;

import java.util.Scanner;

/**
 * @author PraveenPatel 15-Jul-2019
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new ImmutableQueue<Integer>();
		for (int i = 0; i < n; i++) {
			int cmd = sc.nextInt();
			switch (cmd) {
			case 1:
				int a = sc.nextInt();
				q = q.enQueue(a);
				break;
			case 2:
				q = q.deQueue();
				System.out.println(q.isEmpty());
				break;

			case 3:
				System.out.println(q.head());
				break;

			default:
				break;

			}
		}
		sc.close();
	}
}
