package com.farm3.uhgrow.run;

import java.awt.EventQueue;

import com.farm3.uhgrow.view.MainBackGround;

public class UhgrowRun {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainBackGround();
				}
		});
		

	}
}
