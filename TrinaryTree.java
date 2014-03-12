package codingTestAtZillow;

public class TrinaryTree   {
	public TrinaryTreeNode root;
	
	public TrinaryTree(int val){
		this.root = new TrinaryTreeNode(val);
	}
	
	public TrinaryTree(){
		this.root = null;
	}
	
	public TrinaryTreeNode insert(int newVal,TrinaryTreeNode node){
		if(node == null){
			node = new TrinaryTreeNode(newVal);
		} else if(newVal < node.val){
			insert(newVal, node.left);
		} else if(newVal > node.val){
			insert(newVal, node.right);
		} else {
			insert(newVal, node.middle);
		}
		return node;
	}
	
	public TrinaryTreeNode delete(int delVal,TrinaryTreeNode node) {
		if(node == null) {
			throw new RuntimeException();
		} else if(delVal < node.val){
			delete(delVal, node.left);
		} else if(delVal > node.val){
			delete(delVal, node.right);
		} else {
			if(node.middle != null){
				delete(delVal, node.middle);
			} else {
				if(root.right == null){			//just make node.left as node 
					node = node.left;
				} else {						//if nood.right != null need find new node val in the right branch
					node.val = findMinValInRightBranch(node.right);
					node.right = delete(node.val, node.right);		//need delete the node in right branch 
				}
			}
		}
		return node;
	}
	
	private int findMinValInRightBranch(TrinaryTreeNode node){		//because the right node can't be null then don't check it
		if(node.left != null) {
			return findMinValInRightBranch(node.left);
		} else {
			return node.val;
		}
	}
}
