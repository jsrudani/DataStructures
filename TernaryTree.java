/*
 * Program Description: Insert and Delete operation for Ternary Tree. 
 * 						A trinary tree is much like a binary tree but with three child nodes for each parent instead of two 
 * 						Left node being value less than the parent,
 * 						Right node value greater than the parent,
 * 						Middle node value equal to the parent.
 * Author:  Jigar S. Rudani
 * Version: 1.0
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

class TreeNode {
	int data;
	TreeNode leftChild, rightChild, middleChild;
	//Default Constructor
	TreeNode() {}
	TreeNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.middleChild = null;
	}	
}
class TreeOperation {
	TreeNode rootNode;
	public TreeOperation() {
		rootNode = null;
	}
	public TreeOperation(TreeNode Node) {
		rootNode = Node;
	}
	/*
	 * Insert method to insert data passed as argument into empty Tree.
	 */
	public void insertElement(int data) {
		if (rootNode == null) {			
			rootNode = new TreeNode(data);
		} else {
			insertElement(rootNode,data);
		}
	}
	/*
	 * Overloaded Insert method to insert data passed as argument into existing Tree.
	 */
	public void insertElement(TreeNode rootNode,int data) {
		TreeNode intermediateParent;
		intermediateParent = rootNode;
		try {
			while (intermediateParent != null) {
				if (data < intermediateParent.data) {
						if (intermediateParent.leftChild != null) {
							intermediateParent = intermediateParent.leftChild;
						} else {
							intermediateParent.leftChild = new TreeNode(data);
							break;
						}
				} else if (data > intermediateParent.data) {
						if (intermediateParent.rightChild != null) {
							intermediateParent = intermediateParent.rightChild;
						} else {
							intermediateParent.rightChild = new TreeNode(data);
							break;
						}
				} else {
						if(intermediateParent.middleChild != null) {
							intermediateParent = intermediateParent.middleChild;
						} else {
							intermediateParent.middleChild = new TreeNode(data);
							break;
						}
				}
			}
		} catch (Exception e) {
			System.out.println("Error occurred in insertElement Method" + e.getMessage());
		}
	}
	public void deleteElement(int data) {
		if (rootNode == null) {			
			return;
		} else {
			deleteElement(rootNode,data);
		}
	}
	/*
	 * Delete method to delete data passed as argument from existing tree.
	 */
	public void deleteElement(TreeNode rootNode,int data) {
		TreeNode intermediateParent;
		TreeNode prevNode = null;
		intermediateParent = rootNode;
		TreeNode minRightChildNode = null;
		try {
			while (intermediateParent != null) {
				if (data < intermediateParent.data) {
					if (intermediateParent.leftChild != null) {
						prevNode = intermediateParent;
						intermediateParent = intermediateParent.leftChild;
					}
				} else if (data > intermediateParent.data) {
					if (intermediateParent.rightChild != null) {
						prevNode = intermediateParent;
						intermediateParent = intermediateParent.rightChild;
					}
				} else {
					if(intermediateParent.middleChild != null) {
						prevNode = intermediateParent;
						intermediateParent = intermediateParent.middleChild;
					} else {
						if (intermediateParent.leftChild == null && intermediateParent.rightChild == null) {
							// Single node in the tree i.e only root node
							if (prevNode == null) {
								rootNode = null;
								break;
							} else { 
								// Leaf Node deletion
								if (prevNode.leftChild != null && prevNode.leftChild.data == intermediateParent.data) {
									prevNode.leftChild = null;
									break;
								} else if (prevNode.rightChild != null && prevNode.rightChild.data == intermediateParent.data) {
									prevNode.rightChild = null;
									break;
								} else {
									prevNode.middleChild = null;
									break;
								}
							}
							// Deleting Node if either Left child or Right Child is there
						} else if (intermediateParent.leftChild != null && intermediateParent.rightChild == null) {
							if (prevNode.leftChild.data == intermediateParent.data) {
								prevNode.leftChild = intermediateParent.leftChild;
								break;
							} else {
								prevNode.rightChild = intermediateParent.leftChild;
								break;
							}
						} else if (intermediateParent.rightChild != null && intermediateParent.leftChild == null) {
							if (prevNode.leftChild.data == intermediateParent.data) {
								prevNode.leftChild = intermediateParent.rightChild;
								break;
							} else {
								prevNode.rightChild = intermediateParent.rightChild;
								break;
							}
						} else { 
							// Deleting if both Left and Right Child is not null
							minRightChildNode = findMinDataRightSubtree(intermediateParent.rightChild);
							intermediateParent.data = minRightChildNode.data;
							prevNode = intermediateParent;
							intermediateParent = intermediateParent.rightChild;
							data = minRightChildNode.data;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error occurred in deleteElement Method" + e.getMessage());
		}
	}
	/*
	 * Find the Node which has minimum data from Right Subtree for TreeNode pass as argument
	 */
	public TreeNode findMinDataRightSubtree(TreeNode intermediateParentMinRightChild) {
		while (intermediateParentMinRightChild.leftChild != null) {
			intermediateParentMinRightChild = intermediateParentMinRightChild.leftChild;
		}
		return intermediateParentMinRightChild;
	}
	public void displayTree() {
		this.displayTree(rootNode);
	}
	/*
	 * Display Tree structure in Pre-Order i.e Root --> Left --> Middle --> Right
	 */
	public void displayTree(TreeNode rootNode) {
		TreeNode tempNode = rootNode;
		try {
			if (rootNode != null) {
				System.out.println(rootNode.data);
				displayTree(rootNode.leftChild);
				displayTree(rootNode.middleChild);
				displayTree(rootNode.rightChild);
			}
		} catch (Exception e) {
			System.out.println("Error occurred in displayTree Method" + e.getMessage());
		}
	}
}	
public class TernaryTree {
	public static void main(String [] args) {
		TreeOperation treeOpsObj = new TreeOperation();
		TreeNode treeNodeObj = new TreeNode();
		System.out.println("Initial Tree Structure");
		treeOpsObj.insertElement(5);
		treeOpsObj.insertElement(4);
		treeOpsObj.insertElement(5);
		treeOpsObj.insertElement(2);
		treeOpsObj.insertElement(2);
		treeOpsObj.insertElement(9);
		treeOpsObj.insertElement(7);
		System.out.println("PreOrder Traversal Root --> Left --> Middle --> Right ");
		treeOpsObj.displayTree();
		System.out.println("After deleting 7 and 2");
		treeOpsObj.deleteElement(7);
		treeOpsObj.deleteElement(2);
		System.out.println("PreOrder Traversal Root --> Left --> Middle --> Right ");
		treeOpsObj.displayTree();
		System.out.println("After inserting 6 7 8 10");
		treeOpsObj.insertElement(6);
		treeOpsObj.insertElement(7);
		treeOpsObj.insertElement(8);
		treeOpsObj.insertElement(10);
		treeOpsObj.displayTree();
		System.out.println("After deleting 9");
		treeOpsObj.deleteElement(9);
		System.out.println("PreOrder Traversal Root --> Left --> Middle --> Right ");
		treeOpsObj.displayTree();
	}	
}