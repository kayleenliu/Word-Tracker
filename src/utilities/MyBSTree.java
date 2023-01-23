package utilities;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;

public class MyBSTree <E extends Comparable<? super E>> implements BSTreeADT<E>, Serializable {
	BSTreeNode<E> root;
	int size;
	
	public MyBSTree (E element) {
		this.root = new BSTreeNode(element);
		this.size=0;
	}
	
	public MyBSTree () {
		this.root=null;
		this.size=0;
	}
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		return root;
	}

	@Override
	public int getHeight() {
		return getHeight(this.root);
	}

	private int getHeight(BSTreeNode<?> tree) {
		if(tree==null) {
			return 0;
		}else {
			int largestHeight = Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
			return largestHeight + 1;
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void clear() {
		this.root=null;
		this.size=0;
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		BSTreeNode<E> current = this.root;
		while(current != null) {
			if(entry.compareTo(current.getElement())==0) {
				return true;
			}else {
				if(entry.compareTo(current.getElement())>0) {
					current=current.getRight();
				}
				else {
					current=current.getLeft();
				}
			}
		}
		return false;
	}

	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		BSTreeNode<E> current = this.root;
		while(current != null) {
			if(entry.compareTo(current.getElement())==0) {
				return current;
			}else {
				if(entry.compareTo(current.getElement())>0) {
					current=current.getRight();
				}
				else {
					current=current.getLeft();
				}
			}
		}
		return null;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {
		if(newEntry == null) {
			throw new NullPointerException();
		}
		BSTreeNode<E> current = this.root;
		if(this.size==0) {
			this.root = new BSTreeNode(newEntry);
			this.size++;
			return true;
		}
		while(current != null) {
			if(newEntry.compareTo(current.getElement())==0) {
				return false;
			}else {
				if(newEntry.compareTo(current.getElement())>0) {
					if(current.getRight()==null) {
						this.size++;
						current.setRight(new BSTreeNode(newEntry));
						return true;
					}
					current=current.getRight();
				}
				else {
					if(current.getLeft()==null) {
						this.size++;
						current.setLeft(new BSTreeNode(newEntry));
						return true;
					}
					current=current.getLeft();
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<E> inorderIterator() {
		return new Iterator<E>("inorder", this.root);
	}

	@Override
	public Iterator<E> preorderIterator() {
		return new Iterator<E>("preorder", this.root);
	}

	@Override
	public Iterator<E> postorderIterator() {
		return new Iterator<E>("postorder", this.root);
	}

	private class Iterator<E> implements utilities.Iterator<E>{
		private Stack<E> stack = new Stack<E>();
		private BSTreeNode root;

		public Iterator(String order, BSTreeNode root){
			this.root = root;
			if(order.equals("inorder")) {
				this.inOrderStack(this.root);
			}
			else if(order.equals("preorder")) {
				this.preOrderStack(this.root);
			}
			else {
				this.postOrderStack(this.root);
			}
		}

		//preorder traversal
		private void preOrderStack(BSTreeNode current) {
			if(current !=null) {
				if(current.getRight()!=null) {
					preOrderStack(current.getRight());
				}
				if(current.getLeft()!=null) {
					preOrderStack(current.getLeft());
				}
				stack.push((E)current.getElement());
			}
		}

		//inorder traversal
		private void postOrderStack(BSTreeNode current) {
			if(current !=null) {
				stack.push((E)current.getElement());
				if(current.getRight()!=null) {
					postOrderStack(current.getRight());
				}
				if(current.getLeft()!=null) {
					postOrderStack(current.getLeft());
				}
			}
		}
		
		//In order traversal
		private void inOrderStack(BSTreeNode current) {
			if(current !=null) {
				if(current.getRight()!=null) {
					inOrderStack(current.getRight());
				}
				stack.push((E)current.getElement());
				if(current.getLeft()!=null) {
					inOrderStack(current.getLeft());
				}
			}
		}
		
		@Override
		public boolean hasNext(){
			try {
				stack.peek();
			}catch(EmptyStackException e) {
				return false;
			}
			return true;
		}

		@Override
		public E next() throws NoSuchElementException{
			return stack.pop();
		}

	}
	
	
}
