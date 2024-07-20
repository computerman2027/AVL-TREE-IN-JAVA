
public class avltree
{
    Node root;
    public avltree()
    {
        root=null;
    }
    Node insert(Node n,int d)
    {
        Node newnode=new Node(d);
        if(n==null)
        {
            return newnode;
        }
        
        if(d<n.data)
        {
            n.left=insert(n.left,d);
        }
        else if(d>n.data)
        {
            n.right=insert(n.right,d);
        }
        else
        {
            return n;
            //equal keys not allowed
        }
        
        n.height=1+Math.max(height(n.left),height(n.right));
        
        int balance= balanceval(n);
        
        if(balance>1 && d<n.left.data)
        {
            return rotateright(n);
        }
        if(balance<-1 && d>n.right.data)
        {
            return rotateleft(n);
        }
        if(balance>1 && d>n.left.data)
        {
            n.left=rotateleft(n.left);
            return rotateright(n);
        }
        if(balance<-1 && d<n.right.data)
        {
            n.right=rotateright(n.right);
            return rotateleft(n);
        }
        return n;
    }
    Node rotateright(Node x)
    {
        Node y = x.left;
        Node temp = y.right;
        
        y.right=x;
        x.left=temp;
        
        x.height= Math.max(height(x.left),height(x.right))+1;
        y.height= Math.max(height(y.left),height(y.right))+1;
        
        return y;
    }
    Node rotateleft(Node x)
    {
        Node y = x.right;
        Node temp = y.left;
        
        y.left=x;
        x.right=temp;
        
        x.height= Math.max(height(x.left),height(x.right))+1;
        y.height= Math.max(height(y.left),height(y.right))+1;
        
        return y;
    }
    int height(Node n)
    {
        if(n==null)
        return 0;
        return n.height;
    }
    int balanceval(Node n)
    {
        if(n==null)
        return 0;
        return height(n.left)-height(n.right);
    }
    void postorder(Node temp)
    {
        if(temp!=null)
        {
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.data +", ");
        }
    }
    void preorder(Node temp)
    {
        if(temp!=null)
        {
            System.out.print(temp.data +", ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }
    void inorder(Node temp)
    {
        if(temp!=null)
        {
            inorder(temp.left);
            System.out.print(temp.data +", ");
            inorder(temp.right);
        }
    }
    Node delete(Node n,int d)
    {
        if(n==null)
        return n;
        
        if(d<n.data)
        {
            n.left=delete(n.left,d);
        }
        else if(d>n.data)
        {
            n.right=delete(n.right,d);
        }
        else
        {
            if((n.left==null)||(n.right==null))
            {
                Node temp = null;
                if(temp==n.left)
                {
                    temp=n.right;
                }
                else
                {
                    temp=n.left;
                }
                
                //checking if both child are empty
                if(temp==null)
                {
                    temp=n;
                    n=null;
                }
                else
                {
                    //checking if any one child is empty
                    n=temp;
                }
            }
            else
            {
                Node temp = minvalue(n.right);
                n.data=temp.data;
                n.right=delete(n.right,temp.data);
            }
        }
        
        if(n==null)
        {
            return n;
        }
        
        n.height=Math.max(height(n.left),height(n.right))+1;
        
        int balance = balanceval(n);
        
        if(balance>1 && balanceval(n.left)>=0)
        {
            return rotateright(n);
        }
        if(balance>1 && balanceval(n.left)<0)
        {
            n.left=rotateleft(n.left);
            return rotateright(n);
        }
        if(balance<-1 && balanceval(n.right)>0)
        {
            n.right=rotateright(n.right);
            return rotateleft(n);
        }
        if(balance<-1 && balanceval(n.right)<=0)
        {
            return rotateleft(n);
        }
        return n;
    }
    Node minvalue(Node r)
    {
        if(r.left==null)
        {
            return r;
        }
        else
        {
            return minvalue(r.left);
        }
    }
    void find(int d)
    {
        if(root==null)
        {
            System.out.println("Tree doesnot exist");
            return;
        }
        else
        {
            Node temp=root;
            while(temp!=null)
            {
                if(d==temp.data)
                {
                    System.out.println("Data found");
                    return;
                }
                else if(d<temp.data)
                {
                    temp=temp.left;
                }
                else if(d>temp.data)
                {
                    temp=temp.right;
                }
            }
            System.out.println("VALUE DOESNOT EXIST");
        }
    }
}
