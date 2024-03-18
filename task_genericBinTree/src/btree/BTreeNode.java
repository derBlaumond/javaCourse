package btree;

public class BTreeNode<T extends Comparable<T>>  {

	
	private T value;
	private BTreeNode<T> left;
	private BTreeNode<T> right;

	/**
	 * @param value - value of node
	 */
	public BTreeNode(T value) {
		super();
		this.value = value;
	}

	public BTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BTreeNode<T> left) {
		this.left = left;
	}

	public BTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BTreeNode<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}
}
