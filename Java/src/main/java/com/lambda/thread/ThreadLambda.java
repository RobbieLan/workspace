package com.lambda.thread;
/**
 * Replace anonymous inner class(which is commonly seen in thread)
 * */
public class ThreadLambda {
	public static void main(String[] args) {
		Thread t=new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread "+Thread.currentThread().getName()+"is running");
			}
		});
		t.start();
		
		Thread newT=new Thread(()->System.out.println("Thread "+Thread.currentThread().getName()+"is running"));
		newT.start();
		
	}
	
}
/**
 * Basic format of lambda expression
 * 
 *  (params) -> expression
	(params) -> statement
	(params) -> { statements }
 * */
