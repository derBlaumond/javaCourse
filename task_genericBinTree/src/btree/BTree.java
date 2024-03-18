package btree;

public class BTree<T extends Comparable<T>> {

	private BTreeNode<T> root;
	private Traversal traversal;

	/**
	 * Constructor of generic BTree
	 * @param traversal - Pre-Order, In-order, or Post-Order)
	 */
	public BTree(Traversal traversal) {
		this.traversal = traversal;
	}

	/**
	 * Inserts a new Object into tree
	 * @param value	- new value
	 */
	public void insert(T value) {
		if (root == null) {
			//create tree
			this.root = new BTreeNode<T>(value);
			return;
		}
		//insert recursively
		insert(root, value);
	}

	/**
	 * Inserts a new Object into tree (recursive)
	 * @param node	- node to insert
	 * @param value	- new value
	 */
	private void insert(BTreeNode<T> node, T value) {
		
		if (node.getValue().compareTo(value) > 0 ) {
			// node value > new value -> insert new value into left subtree 
			if (node.getLeft() == null) {
				// no subtree -> insert here
				node.setLeft(new BTreeNode<T>(value));
				return;
			} else {
				// insert into subtree
				insert(node.getLeft(), value);
			}
		} else if (node.getValue().compareTo(value) < 0) {
			// node value < new value -> insert new value into right subtree 
			if (node.getRight() == null) {
				// no subtree -> insert here
				node.setRight(new BTreeNode<T>(value));
				return;
			} else {
				// insert into subtree
				insert(node.getRight(), value);
			}
		} else {
			//value already exist, do not insert
			return;
		}
	}
	
	/**
	 * Sets traversal algorithm
	 * @param traversal - new order
	 */
	public void setTraversal(Traversal traversal) {
		this.traversal = traversal;
	}
	
	@Override
	public String toString() {
		return toString(root);
	}

	/**
	 * Prints BTree recursively
	 * @param current - node to print
	 */
	private String toString(BTreeNode<T> current) {
		if (current == null) {
			return "";
		}
		
		String result = "";
		switch (traversal) {
		case PREORDER:
			result += current.getValue() + ", ";
			result += toString(current.getLeft());
			result += toString(current.getRight());
			break;
		case INORDER:
			result += toString(current.getLeft());
			result += current.getValue() + ", ";
			result += toString(current.getRight());
			break;
		case POSTORDER:
			result += toString(current.getLeft());
			result += toString(current.getRight());
			result += current.getValue() + ", ";
			break;
		}
		return result;
	}
	

}
