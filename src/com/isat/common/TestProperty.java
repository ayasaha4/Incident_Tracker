package com.isat.common;

import java.io.IOException;

public class TestProperty {

	public static void main(String[] args) {

		PropertyFileLoader load = new PropertyFileLoader();
		try {
			System.out.println(load.loadProperty("error"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
