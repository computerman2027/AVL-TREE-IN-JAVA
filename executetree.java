import java.util.*;
public class executetree
{
    avltree bt;
    void main()
    {
        Scanner sc = new Scanner(System.in);
        bt = new avltree();
        int choice,val;
        while(true)
        {
            System.out.println("MENU");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. Prefix arrangement");
            System.out.println("4. Infix arrangement");
            System.out.println("5. Postfix arrangement");
            System.out.println("6. Is Node present ");
            System.out.println("7. Exit");
            System.out.println("Enter your choice : ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter a value : ");
                    val=sc.nextInt();
                    bt.root=bt.insert(bt.root,val);
                    break;
                case 2:
                    System.out.println("Enter a value : ");
                    val=sc.nextInt();
                    bt.root=bt.delete(bt.root,val);
                    break;
                case 3:
                    bt.preorder(bt.root);
                    System.out.println();
                    break;
                case 4:
                    bt.inorder(bt.root);
                    System.out.println();
                    break;
                case 5:
                    bt.postorder(bt.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter a value : ");
                    val=sc.nextInt();
                    bt.find(val);
                    break;
                case 7:
                    System.out.println("THANK YOU");
                    return;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
    }
}
