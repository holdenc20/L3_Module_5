package data_structures;

import java.util.ArrayList;

/**
 * Copyright The League of Amazing Programmers 2013-2017 Level 3 Two ArrayList
 * Cleaning Exercises Duration=.00 Platform=Eclipse Type=Recipe Objectives=
 */

public class RemovingStuffFromArrayLists {

	public static void main(String[] args) {

		class Stuff {
		}
		class Worm extends Stuff {
		}
		class Dirt extends Stuff {
		}
		ArrayList<Stuff> stuffIFoundInTheYard = new ArrayList<Stuff>();
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());

		System.out.println(stuffIFoundInTheYard.size());

		/* TODO 1: Clean out the dirt but keep the delicious worms. */
		for(int i=0;i<stuffIFoundInTheYard.size();i++) {
			System.out.println(stuffIFoundInTheYard.get(i).getClass().getSimpleName());
			if(stuffIFoundInTheYard.get(i).getClass().getSimpleName().equals("Dirt")){
				i--;
				stuffIFoundInTheYard.remove(i);
			}
		}
		
		System.out.println(stuffIFoundInTheYard.size()); // should be 2

		ArrayList<Character> truth = new ArrayList<Character>();
		truth.add('#');
		truth.add('s');
		truth.add('u');
		truth.add('#');
		truth.add('n');
		truth.add('s');
		truth.add(' ');
		truth.add('#');
		truth.add('o');
		truth.add('u');
		truth.add('#');
		truth.add('t');
		truth.add('#');
		truth.add(' ');
		truth.add('g');
		truth.add('#');
		truth.add('n');
		truth.add('s');
		truth.add('#');
		truth.add(' ');
		truth.add('o');
		truth.add('#');
		truth.add('u');
		truth.add('t');
		System.out.println(truth.size());
		/* TODO 2: Remove the hash symbols and print out the truth. */
		for(int i=truth.size()-1;0<i;i--) {
			if(truth.get(i).equals('#')){
				truth.remove(i);
			}
			else {
				
			}
		}
		for(int x=0;x<truth.size();x++) {
			System.out.println(truth.get(x));
		}
		System.out.println(truth.size());
	}
}
