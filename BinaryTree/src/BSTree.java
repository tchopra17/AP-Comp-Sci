import java.util.Stack;

public class BSTree<E extends Comparable>
{
    private TreeNode<E> myRoot;

    public TreeNode getRoot()
    {
        return myRoot;
    }

    public void insert(E obj)
    {
        myRoot = insert(myRoot, obj);
    }

    private TreeNode<E> insert(TreeNode node, E data){
        if (node == null)
        {
            node = new TreeNode(data,null,null);
        }
        else if (data.compareTo(node.getValue()) < 0)
        {
            node.setLeft(insert(node.getLeft(), data));
        }
        else if (data.compareTo(node.getValue()) > 0)
        {
            node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    E find(E itemtofind)
    {   
        return find(itemtofind,myRoot);
    }

    E find(E itemtofind, TreeNode<E> node){   
        if (node == null) {
            return null;
        }
        if (node.getValue().equals(itemtofind)){
            return node.getValue();
        }
        else if (itemtofind.compareTo(node.getValue()) < 0){
            return find(itemtofind,node.getLeft());        
        }
        else if (itemtofind.compareTo(node.getValue()) > 0){
            return find(itemtofind,node.getRight());
        }
        return null;
    }

    public E remove(E itemtofind){
        return null;
    }

    public void inorder(){
        inorder(myRoot);
    }

    private void inorder(TreeNode<E> node){
        if (node != null){
            inorder(node.getLeft());
            System.out.println(node.getValue());
            inorder(node.getRight());
        }
    }
    public void inorderNoRecur(){
        inorderNoRecur(myRoot);
    }

    private void inorderNoRecur(TreeNode<E> node){
    	System.out.println("This is nonrecursive inorder.");
    	
    	TreeNode temp;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        temp = node;
        
        do {
        	while (temp != null){
        		stack.push(temp);
        		temp = temp.getLeft();
        	}
        	if (!stack.isEmpty()){
        		temp = stack.pop();
        	}
        	System.out.println(temp.getValue());
        	temp = temp.getRight();
        }while(!stack.empty() || temp != null);
    }
    public void postorder()
    {
        postorder(myRoot);
    }

    private void postorder(TreeNode<E> node)
    {
        if (node != null)
        {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void preorder()
    {
        preorder(myRoot);
    }

    private void preorder(TreeNode<E> node)
    {
        if (node != null)
        {
            System.out.print(node.getValue() + ", ");
            preorder(node.getLeft());
            preorder(node.getRight());   
        }
    }
    public int leafsize()
    {
        return leafsize(myRoot);
    }

    private int leafsize(TreeNode<E> node)
    {
        int counter = 0;
        if (node != null)
        {
            if (node.getLeft() == null && node.getRight() == null)
            {
                counter++;
            }
            else
            {
                counter += leafsize(node.getLeft());
                counter += leafsize(node.getRight());
            }
        }
        return counter;
    }

    int nodesize()
    {
        return nodesize(myRoot);
    }

    private int nodesize(TreeNode<E> node)
    {
        int counter = 0;
        if (node != null)
        {
            counter++;
            counter += nodesize(node.getLeft());
            counter += nodesize(node.getRight());
        }
        return counter;
    }

    public int findheight()
    {
        return findheight(myRoot);
    }

    private int findheight(TreeNode<E> node)
    {
        int leftcounter = 0;
        int rightcounter = 0;
        if (node != null)
        {
            if (node.getLeft() != null)
            {
                leftcounter += findheight(node.getLeft());
            }
            if (node.getRight() != null)
            {
                rightcounter += findheight(node.getRight());
            }
        }
        else
        {
            return 0;
        }
        if (Math.max(leftcounter,rightcounter) == leftcounter)
        {
            return leftcounter + 1;
        }
        else
        {
            return rightcounter + 1;
        }
    }

    public int findwidth()
    {
        return findwidthRootNode(myRoot);
    }

    private int findwidthRootNode(TreeNode<E> node)
    {
        int counter = 0;
        int leftcounter = 0;
        int rightcounter = 0;
        int answer = 0;

        if (node != null)
        {
            counter += findheight(node.getLeft());
            counter += findheight(node.getRight());
            counter++; 
        }
        if (node.getLeft() != null)
        {
            leftcounter = findwidthRootNode(node.getLeft());
        }
        if (node.getRight() != null)
        {
            rightcounter = findwidthRootNode(node.getRight());
        }
        answer = Math.max(counter,(Math.max(leftcounter,rightcounter)));
        return answer;
    }

    int size(){
        return size(myRoot);
    }

    private int size(TreeNode<E> node){
        int counter = 0;
        if (node != null){
            counter++;
            counter += size(node.getLeft());
            counter += size(node.getRight());
        }
        return counter;
    }
    public void clear()
    {
        myRoot = null;
    }
}