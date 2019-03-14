package HW3.CS3310;

import java.util.ArrayList;

public class HashEntry {
	private String key;
	private String[] value = new String[1];
	private HashEntry next;
	
	public HashEntry() {
		
	}
	
	public HashEntry(String descriptions, String urls) {
		key = descriptions;
		value[0] = urls;
		
		
		//System.out.println(key+"\n"+value.toString());
		//System.out.println(getValue().toString());
	}
	
	public String getKey() {
		//System.out.println(key);
		return key;
	}
	
	public HashEntry getNext(){
		return next;
	}
	
	public void setNext(HashEntry nxt) {
		next = nxt;
	}
	
	public String[] getValue() {
		//System.out.println(value.toString());
		return value;
	}
	public void addValue(String[] toAdd) {
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i =0; i<value.length;i++) {
			temp.add(value[i]);
		}
		for(int j =0; j<toAdd.length;j++) {
			if(!temp.contains(toAdd[j])){
				temp.add(toAdd[j]);
			}
		}
		value = new String[temp.size()];
		for(int v= 0;v<temp.size();v++) {
			value[v]=temp.get(v);
		}
	}
	
	public boolean containsValue(String val) {
		ArrayList<String> keywords= new ArrayList<String>();
		for(int i = 0; i<value.length;i++) {
			keywords.add(value[i]);
		}
		return  keywords.contains(val);
	}
}


