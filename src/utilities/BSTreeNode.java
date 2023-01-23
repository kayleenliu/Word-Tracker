package utilities;

import java.io.Serializable;

public class BSTreeNode <E extends Comparable> implements Serializable {
	//variables
	private E element;
	private BSTreeNode left = null;
	private BSTreeNode right = null;
	
	//constructors
	public BSTreeNode(E elem) {
		this.element = elem;
	}
	
	public BSTreeNode(E elem, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = elem;
		this.left = left;
		this.right = right;
	}

	//getters and setters
	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public BSTreeNode getLeft() {
		return left;
	}

	public void setLeft(BSTreeNode left) {
		this.left = left;
	}

	public BSTreeNode getRight() {
		return right;
	}

	public void setRight(BSTreeNode right) {
		this.right = right;
	}

	//BSTreeNode methods
	

}
