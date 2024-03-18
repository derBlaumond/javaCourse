### task: implementing binary tree with generics

**Overview**: This task involves implementing a binary tree for arbitrary data types, focusing on utilizing Java Generics and the Comparable interface. It requires creating a generic binary tree capable of handling arbitrary data types through the use of Java Generics and the Comparable interface. This task not only tests the ability to adapt existing code for broader functionality but also evaluates understanding of data structures, generics, and object-oriented programming principles.

### BTreeNode und BTree
- **Objective**: Adapt the `BTreeNode` and `BTree` classes, originally designed for the `int` datatype, to support arbitrary data types using Java Generics.
- **Source Code**: Initial versions of the classes can be copied from the provided GitHub repository.
- **Implementation**: Utilize Java Generics and the `Comparable<T>` interface to allow the tree to store any comparable data type.

### Traversal
- **Traversal Enumeration**: Add an enumeration named `Traversal` with values `PREORDER`, `INORDER`, and `POSTORDER`.
- **BTree Class Enhancement**: Introduce a constructor in the `BTree` class that accepts the `Traversal` enum as a parameter and stores it in an attribute named `traversal`.
- **toString Method Override**: Override the `toString()` method in the `BTree` class to print the tree in the order specified by the `traversal` attribute.

### ChemElement
- **Objective**: Create a `ChemElement` class with `name` (String) and `density` (double) attributes that implements the `Comparable` interface.
- **Implementation Details**: Include a suitable constructor, override the `toString()` method, and implement the `compareTo()` method to compare elements based on their density (lighter elements considered "smaller").

### BTreeTest 
- **Objective**: Test the implementation by writing a `BTreeTest` class.
- **String Tree Testing**: Create a `BTree` for `String` data type, insert at least 10 different values, and test the output using the customized `toString()` method.
- **ChemElement Tree Testing**: Create another `BTree` for `ChemElement` objects, fill it with at least 10 different instances, and test the outputs.