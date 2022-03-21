package com.ch.java1;

import java.io.Serializable;

/**
 * @author chenpi
 * @create 2022-03-21 15:56
 */
public class Creature<T> implements Serializable {
	private char gender;
	public double weight;
	
	private void breath(){
		System.out.println("Creature breath");
	}

	public void eat(){
		System.out.println("Creature eat");
	}

}
