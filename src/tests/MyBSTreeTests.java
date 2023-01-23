package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.TreeException;
import utilities.Iterator;
import utilities.MyBSTree;

public class MyBSTreeTests {
	
	//Attributes
	MyBSTree<Integer> mytree = new MyBSTree<Integer>();

	@Before
	public void setUp() throws Exception {

	}
	@After
	public void tearDown() throws Exception {
		mytree=null;
	}

	@Test
	public void testSize1() {
		int expected=3;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		int actual = mytree.size();
		assertEquals(expected,actual);
	}
	@Test
	public void testSize2() {
		int expected=4;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		mytree.add(4);
		int actual = mytree.size();
		assertEquals(expected,actual);
	}
	@Test
	public void testSize3() {
		int expected=0;
		int actual = mytree.size();
		assertEquals(expected,actual);
	}
	@Test
	public void testSize4() {
		int expected=3;
		mytree.add(8);
		mytree.add(9);
		mytree.add(10);
		int actual = mytree.size();
		assertEquals(expected,actual);
	}
	@Test
	public void testSize5() {
		int expected=3;
		mytree.add(8);
		mytree.add(3);
		mytree.add(1);
		int actual = mytree.size();
		assertEquals(expected,actual);
	}
	@Test
	public void clearTest1() {
		int expected=0;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		mytree.clear();
		int actual = mytree.size();
		assertEquals(expected,actual);
	}
	@Test
	public void testHeight1() {
		int expected=2;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		int actual = mytree.getHeight();
		assertEquals(expected,actual);
	}
	@Test
	public void testHeight2() {
		int expected=3;
		mytree.add(1);
		mytree.add(2);
		mytree.add(3);
		int actual = mytree.getHeight();
		assertEquals(expected,actual);
	}
	@Test
	public void testHeight3() {
		int expected=1;
		mytree.add(2);
		int actual = mytree.getHeight();
		assertEquals(expected,actual);
	}
	@Test
	public void testHeight4() {
		int expected=0;
		int actual = mytree.getHeight();
		assertEquals(expected,actual);
	}
	@Test
	public void containsTest1() throws TreeException {
		boolean expected = true;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		boolean actual = mytree.contains(1);
		assertEquals(expected,actual);
	}
	@Test
	public void containsTest2() throws TreeException {
		boolean expected = true;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		boolean actual = mytree.contains(2);
		assertEquals(expected,actual);
	}
	@Test
	public void containsTest3() throws TreeException {
		boolean expected = true;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		boolean actual = mytree.contains(3);
		assertEquals(expected,actual);
	}
	@Test
	public void containsTest4() throws TreeException {
		boolean expected = false;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		boolean actual = mytree.contains(4);
		assertEquals(expected,actual);
	}
	@Test
	public void searchTest1() throws TreeException {
		int expected=3;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		int actual = (int) mytree.search(2).getRight().getElement();
		assertEquals(expected,actual);
	}
	@Test
	public void searchTest2() throws TreeException {
		int expected=1;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		int actual = mytree.search(1).getElement();
		assertEquals(expected,actual);
	}
	@Test
	public void searchTest3() throws TreeException {
		Object expected = null;
		mytree.add(2);
		mytree.add(1);
		mytree.add(3);
		Object actual = mytree.search(4);
		assertEquals(expected,actual);
	}
	@Test
	public void inOrderIterator(){
		boolean expected = true;
		int[] expectedResult= {1,3,4,6,7,8,10,13,14};
		
		mytree.add(8);
		mytree.add(3);
		mytree.add(1);
		mytree.add(6);
		mytree.add(4);
		mytree.add(7);
		mytree.add(10);
		mytree.add(14);
		mytree.add(13);
		
		int[] actualResult = new int[9];
		Iterator<Integer> iter = mytree.inorderIterator();
		for(int i=0; i<9; i++) {
			actualResult[i]=iter.next();
		}
		boolean actual= true;
		for(int i=0; i<9; i++) {
			if(actualResult[i]!=expectedResult[i]) {
				actual=false;
			}
		}
		assertEquals(expected,actual);
	}
	@Test
	public void preOrderIterator(){
		boolean expected = true;
		int[] expectedResult= {8,3,1,6,4,7,10,14,13};
		
		mytree.add(8);
		mytree.add(3);
		mytree.add(1);
		mytree.add(6);
		mytree.add(4);
		mytree.add(7);
		mytree.add(10);
		mytree.add(14);
		mytree.add(13);
		
		int[] actualResult = new int[9];
		Iterator<Integer> iter = mytree.preorderIterator();
		for(int i=0; i<9; i++) {
			actualResult[i]=iter.next();
		}
		boolean actual= true;
		for(int i=0; i<9; i++) {
			if(actualResult[i]!=expectedResult[i]) {
				actual=false;
			}
		}
		assertEquals(expected,actual);
	}
	@Test
	public void postOrderIterator(){
		boolean expected = true;
		int[] expectedResult= {1,4,7,6,3,13,14,10,8};
		
		mytree.add(8);
		mytree.add(3);
		mytree.add(1);
		mytree.add(6);
		mytree.add(4);
		mytree.add(7);
		mytree.add(10);
		mytree.add(14);
		mytree.add(13);
		
		int[] actualResult = new int[9];
		Iterator<Integer> iter = mytree.postorderIterator();
		for(int i=0; i<9; i++) {
			actualResult[i]=iter.next();
		}
		boolean actual= true;
		for(int i=0; i<9; i++) {
			if(actualResult[i]!=expectedResult[i]) {
				actual=false;
			}
		}
		assertEquals(expected,actual);
	}
}
