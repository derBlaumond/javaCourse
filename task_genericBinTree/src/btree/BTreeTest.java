package btree;

import java.util.Random;

public class BTreeTest {
	public static void main(String[] args) {	
		
		//Integers
		
		Random r = new Random();
		BTree<Integer> intTree = new BTree<Integer>(Traversal.PREORDER);
		
		System.out.println("Values: ");
		for (int i = 0; i < 20; i++) {
			int value = r.nextInt(100)+1;
			intTree.insert(value);
			if (i < 19) {
				System.out.print(value + ", ");
			} else {
				System.out.println(value);
			}
		}	
		System.out.println("");
		
		System.out.println("Pre-Order: " + intTree);
		System.out.println();
		
		intTree.setTraversal(Traversal.INORDER);
		System.out.println("In-Order: " + intTree);
		System.out.println();
		
		intTree.setTraversal(Traversal.POSTORDER);
		System.out.println("Post-Order: " + intTree);
		System.out.println();
		
		//Strings
		
		BTree<String> stringTree = new BTree<String>(Traversal.PREORDER);
		
		System.out.println("Values: ");
		String[] texts = {"White", "Tan", "Yellow", "Orange", "Red", "Pink", "Purple", "Blue", "Green", "Gray"};
		for (int i = 0; i < texts.length; i++) {
			stringTree.insert(texts[i]);
			if (i < texts.length -1) {
				System.out.print(texts[i] + ", ");
			} else {
				System.out.println(texts[i]);
			}
		}
		System.out.println();
		System.out.println("Pre-Order: " + stringTree);
		System.out.println();
		
		stringTree.setTraversal(Traversal.INORDER);
		System.out.println("In-Order: " + stringTree);
		System.out.println();
		
		stringTree.setTraversal(Traversal.POSTORDER);
		System.out.println("Post-Order: " + stringTree);
		System.out.println();
		
		//ChemElements
		
		BTree<ChemElement> elementsTree = new BTree<ChemElement>(Traversal.PREORDER);
		
		System.out.println("Values: ");
		
		ChemElement e = new ChemElement("Lithium", 0.53);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Hydrogen", 0.09);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Rubidium", 1.63);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Neon", 0.9);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Helium", 0.18);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Oxygen", 1.43);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Calcium", 1.55);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Nitrogen", 1.25);
		System.out.print(e + ", ");
		elementsTree.insert(e);
		
		e = new ChemElement("Argon", 0.86);
		System.out.print(e + ", ");
		elementsTree.insert(e);
				
		e = new ChemElement("Sodium", 0.97);
		System.out.print(e + ", ");
		elementsTree.insert(e);
				
		System.out.println();
		System.out.println("Pre-Order: " + elementsTree);
		System.out.println();
		
		elementsTree.setTraversal(Traversal.INORDER);
		System.out.println("In-Order: " + elementsTree);
		System.out.println();
		
		elementsTree.setTraversal(Traversal.POSTORDER);
		System.out.println("Post-Order: " + elementsTree);
		System.out.println();
	}
}

