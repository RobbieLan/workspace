package com.patterns.statemachine;

import java.util.Scanner;
/**
 * ����,����0/1/2,��ͬ��״̬����ֻ�ܸ��ض���״̬,����ͨ��
 * https://www.cnblogs.com/hellocsl/p/4000122.html
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPlayer player = new VideoPlayer();
		int i = -1;
		while ((i = sc.nextInt()) != -1) {
			player.request(i);
		}
	}
}
