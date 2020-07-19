package com.codebin;
import java.io.File;
import java.util.AbstractList;
import java.util.logging.Logger;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

import jdk.internal.jline.internal.Log;
 class UserList<E> extends AbstractList<E> {

	
	public static final org.apache.log4j.Logger log1=LogManager.getLogger(UserList.class);
	Object[] clist;
	int list_size=10;
	 int filled_elements=0;
public UserList() {
	clist=new Object[10];
}
public E get(int index) {
	@SuppressWarnings("unchecked")
	E e=(E) clist[index];
	log1.info("get request accepted");
	return e;
}
public E set (int index,Object element) {
	@SuppressWarnings("unchecked")
	E previousValue=(E)clist[index];
	clist[index]=element;
	log1.info("Element is inserted at given index successfully");
	return previousValue;
}
public int size() {

	log1.info("Size request is accepted and size is reurned");
	return clist.length;
}

	public boolean add(Object element) {
	
		
		if(filled_elements==10)
			return false;
		log1.info("add request is accepted successfully");
		clist[filled_elements]=element;
		filled_elements+=1;
		return true;
		
	}
	public int removeobj(Integer element) {
		//@SuppressWarnings("unchecked")
		if(filled_elements==0) {
			log1.info("No elements in the list");
			return -1;}
		int i,j;
		for(i=0;i<filled_elements;i++ ) {
			if(clist[i]==element)
			{
				log1.info("Element found");
				for(j=i;j<filled_elements-1;j++) {
					clist[j]=clist[j+1];
				}
				filled_elements-=1;
				log1.info("Element is deleted from the list");
				return i;
			}
		}log1.info("Element not found");
		return -1;
	}
	public void print() {
		@SuppressWarnings("unchecked")
		int i=0;
		log1.info("print request is accepted successfully");
		for(i=0;i<filled_elements;i++) {
			
		log1.info(clist[i]+"\t");	
		}
		
	}

}

class CustomerCollectionDemo{
	public static final org.apache.log4j.Logger log2=LogManager.getLogger(UserList.class);
	public static void main(String args[]) {
	Scanner scannerObject=new Scanner(System.in);
	UserList<Integer> example_list=new UserList<Integer>();
	int index,element;
	for(int i=1;i<=10;i++) {
		example_list.add(i);
	}
	
	example_list.print();
	log2.info("Enter the index you want to insert in");
	index=scannerObject.nextInt();
	log2.info("Enter the element you want to insert");
	element=scannerObject.nextInt();
	example_list.set(index,element);
	log2.info("Enter the element you want to delete");
	Integer ele=scannerObject.nextInt();
	log2.info(example_list.removeobj(ele));
	int index_to_get=scannerObject.nextInt();
	log2.info("Element at index "+example_list.get(index_to_get));
	example_list.print();
	scannerObject.close();
	
}

}