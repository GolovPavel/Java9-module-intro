package com.jdojo.intro;

public class Welcome {
	public static void main(String[] args) {
		System.out.println("Welcome to java module system!");

		Class<Welcome> cls = Welcome.class;
		Module mod = cls.getModule();
		String moduleName = mod.getName();
		System.out.println("The current module: " + moduleName);
	}
}
