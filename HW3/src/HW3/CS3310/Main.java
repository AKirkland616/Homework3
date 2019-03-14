package HW3.CS3310;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyQueue1<String> lookup = new MyQueue1<String>();
		
		
		Scanner input = new Scanner(System.in);
		MyHashMap hm = new MyHashMap();
		File read = new File("url.txt");
		Scanner scan = new Scanner(read);
		final long Start = System.currentTimeMillis();
		createHashMap(scan, hm);
		final long End = System.currentTimeMillis();
		System.out.println("Creating the hashMap took "+(End-Start)+" ms.");
		
		
		String d = "";
		System.out.println("Please Enter Keywords seperated by the enter key,");
		System.out.println("or type file to read input file.");
		String[] results;
		
		while(!d.equals("!")) {
			//input.n
			d = input.next();
			lookup.enqueue(d);
			if (d.equals("?")) {
				lookup.dequeue();
				results = hm.search(lookup);
				if(results!=null) {
					for(int i = 0; i<results.length;i++) {
						System.out.println(results[i]);
					}
				}else {
					System.out.println("Search resulted in nothing.");
				}
					
			}
		}
		
		String[] s = hm.containsOr(hm.get("csa"), hm.get("yellow"));
		for(int i = 0; i<s.length;i++) {
			System.out.println(s[i]);
		}
	}
	
	public static void createHashMap(Scanner scan, MyHashMap hm) {
		while (scan.hasNext()) {
			String key = scan.nextLine();
			String[] descriptions = scan.nextLine().split(" ");
			for(int i = 0; i< descriptions.length;i++) {
				hm.put(descriptions[i], key);
			}			
		}
	}
}