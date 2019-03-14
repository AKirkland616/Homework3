package HW3.CS3310;


import java.util.ArrayList;
import java.util.Stack;

public class MyHashMap {
	
	private ArrayList<HashEntry>bucket=new ArrayList<HashEntry>();
	private int numBuckets=100000;
	private int size;

	public MyHashMap(){
		
		for(int i=0;i<numBuckets;i++){
			bucket.add(null);
		}
	}
	
	///Close but does not work
	public String[] search(MyQueue1<String> search){
		
		Stack<String[]> waitList = new Stack<String[]>();
		String[] matchingUrls=null;
		if(search.size()==1) {
			String op = search.dequeue();
			//if(!op.equals("&&") && !op.equals("||")) {
				matchingUrls=get(op);
			//}
		}else {
			while(!search.isEmpty()) {
				String op = search.dequeue();
				if(op.equals("&&") || op.equals("||")) {
					
					if(op.equals("&&")) {
						waitList.push(containsAnd(waitList.pop(),waitList.pop()));
						
					}else if(op.equals("||")) {
						waitList.push(containsOr(waitList.pop(),waitList.pop()));
					}
				}else {
					waitList.push(get(op));
				}
			}
			matchingUrls = waitList.pop();
		}
		
		//search.enqueue(matchingUrls);
		return matchingUrls;
	}
	
	//not needed as far as i know
	/**
	public String[] containsAnd(String first, String second) {
		String[] results = null;
		if(!containsKey(first) || !containsKey(second)) {
			
		}else {
			results = get(first);
			String[] nextGroup = get(second);
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					place.remove(j);
				}
			}
			results = new String[place.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= place.get(i);
			}
		}
		
		return results;
	}
	
public String[] containsAnd( String second, String[] results) {
		
		if(!containsKey(second)) {
			results =null;
		}else if(results==null){
			
		}else {
			String[] nextGroup = get(second);
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					place.remove(j);
				}
			}
			results = new String[place.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= place.get(i);
			}
		}
		
		return results;
	}
	
	public String[] containsAnd(String[] results, String second) {
		
		if(!containsKey(second)) {
			results =null;
		}else if(results==null){
			
		}else {
			String[] nextGroup = get(second);
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					place.remove(j);
				}
			}
			results = new String[place.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= place.get(i);
			}
		}
		
		return results;
	}
	**/
	public String[] containsAnd(String[] results, String[] nextGroup) {
		if(results==null || nextGroup==null){
			results = null;
		}else {
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					place.remove(j);
				}
			}
			results = new String[place.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= place.get(i);
			}
		}
		return results;
	}
 	
	//also not needed
	/**
	public String[] containsOr(String first, String second) {
		String[] results = null;
		
		if(!containsKey(first) || !containsKey(second)) {
			if(containsKey(first)){
				results=get(first);
			}else if(containsKey(second)) {
				results=get(second);
			}
		}else {
			results = get(first);
			String[] nextGroup = get(second);
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					rere.add(place.get(j));;
				}
			}
			results = new String[rere.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= rere.get(i);
			}
		}
		
		return results;
 	}
	
	public String[] containsOr(String[] results, String second) {
		if(!containsKey(second) || results == null) {
			if(results == null) {
				results=get(second);
			}
		}else {
			String[] nextGroup = get(second);
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					rere.add(place.get(j));;
				}
			}
			results = new String[rere.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= rere.get(i);
			}
		}
		return results;
	}
	
	public String[] containsOr( String second, String[] results) {
		if(!containsKey(second) || results == null) {
			if(results == null) {
				results=get(second);
			}
		}else {
			String[] nextGroup = get(second);
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					rere.add(place.get(j));;
				}
			}
			results = new String[rere.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= rere.get(i);
			}
		}
		return results;
	}
	**/
	
	
	public String[] containsOr(String[] results, String[] nextGroup) {
		if(results==null || nextGroup==null) {
			if(results!=null){
				
			}else if(nextGroup!=null) {
				results=nextGroup;
			}
		}else {
			ArrayList<String> place = new ArrayList<String>();
			for(int i = 0 ; i<nextGroup.length;i++) {
				place.add(nextGroup[i]);
			}
			ArrayList<String> rere = new ArrayList<String>();
			for(int i = 0 ; i<results.length;i++) {
				rere.add(results[i]);
			}
			for(int j = place.size()-1;j>-1;j--) {
				if(!rere.contains(place.get(j))) {
					rere.add(place.get(j));;
				}
			}
			results = new String[rere.size()];
			for(int i = 0 ; i<results.length;i++) {
				results[i]= rere.get(i);
			}
		}
		return results;
	}
	
	private int getBucketIndex(String key){
		int hash = 7;
        for (int i = 0; i < key.length(); i++) {
            hash += (hash*31 + key.charAt(i));
        }
		return Math.abs(hash%numBuckets);
	}
	
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	
	public boolean containsKey(String key) {
		// TODO Auto-generated method stub
		int index=getBucketIndex(key);
		HashEntry head=bucket.get(index);
		while(head!=null){
			if(head.getKey().equals(key)){
				return true;
			}
			head=head.getNext();
		}
		return false;	
	}

	
	public String[] get(String key) {
		// TODO Auto-generated method stub
		int index=getBucketIndex(key);
		HashEntry head = new HashEntry();
				head =bucket.get(index);
				//System.out.println(bucket.get(index).getKey()+"ffffffff/n"+ bucket.get(index).getValue().length);
		while(head!=null){
			if(head.getKey().equals(key)){
				//System.out.println(head.getKey()+" jhgkjhhj\n"+ head.getValue().toString());
				return head.getValue();
			}
			head=head.getNext();
		}
		return null;	
	}

	
	public void put(String key, String value) {
		// TODO Auto-generated method stub
		int index=getBucketIndex(key);
		//System.out.println(index);
		HashEntry head=bucket.get(index);
		HashEntry toAdd=new HashEntry(key, value);
		//System.out.println(toAdd.getKey()+"\n"+toAdd.getValue()[0]);
		
		if(head==null){
			bucket.set(index, toAdd);
			//System.out.println(index);
			//System.out.println(bucket.get(index).getKey()+" "+bucket.get(index).getValue().toString());
			size++;
			
		}else{
			//System.out.println("collision at " + index);
			while(head!=null){
				if(head.getKey().equals(key)){
					head.addValue(toAdd.getValue()); //= value;
					//size++;
					break;
				}
				head=head.getNext();
			}
			if(head==null){
				head=bucket.get(index);
				toAdd.setNext(head);//=head;
				bucket.set(index, toAdd);
				size++;
			}
		}
		
		/**
		if((1.0*size)/numBuckets>0.7){
			//do something
			ArrayList<HashEntry>tmp=new ArrayList<HashEntry>();
			tmp=bucket;
			bucket = new ArrayList<HashEntry>();
			numBuckets=2*numBuckets;
			for(int i=0;i<numBuckets;i++){
				bucket.add(null);
			}
			for(HashEntry headNode:tmp){
				while(headNode!=null){
					put(headNode.getKey(), headNode.getValue());
					headNode=headNode.getNext();
				}
			}
			
			
		}
		**/
	}
	

	
	public String[] remove(String key) {
		// TODO Auto-generated method stub
		
		int index= getBucketIndex(key);
		HashEntry head=bucket.get(index);
		if(head==null){
			return null;
		}
		if(head.getKey().equals(key)){
			String[] val=head.getValue();
			head=head.getNext();
			bucket.set(index, head);
			size--;
			return val;
		}
		else{
			HashEntry prev=null;
			while(head!=null){
				
				if(head.getKey().equals(key)){
					prev.setNext(head.getNext());//=head.next;
					size--;
					return head.getValue();
				}
				prev=head;
				head=head.getNext();
			}
			size--;
			return null;
		}
	}

	

	
	public void clear() {
		// TODO Auto-generated method stub
		bucket.clear();
		
	}


	
	public ArrayList<HashEntry> entrySet() {
		// TODO Auto-generated method stub
		return bucket;
	}

}
