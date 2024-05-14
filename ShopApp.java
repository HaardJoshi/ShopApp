/** @author: Hard Joshi
* @version: 21.12.2023
*/
import java.util.*;
public class ShopApp 
{
    static Scanner kbd= new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("This App was developed by:" + "\n" + "HARD JOSHI [2512658]" + "\n");
        System.out.println("--- WELCOME TO THE SHOP ---");
        
//Creating the array Product to hold 5 products        
        Product[] shop = new Product[5];

        shop[0] = new Product("Jackets ", 150, 299.99);
        shop[1] = new Product("Jeans   ", 120, 149.99);
        shop[2] = new Product("Trousers", 120, 129.99);
        shop[3] = new Product("Boots   ", 250, 69.99);
        shop[4] = new Product("Socks   ", 100, 14.99);

        int proName = 0;
        int Qty = 0, in = 0;
        double Price = 0;
        char x = 'x';

//calling the appMenu method to dispplay the menu
        AppMenu(proName, Qty, Price, shop, in, x);

        System.out.println("--- THANK YOU FOR USING THE APP ---");
    }

//this method will give users the menu for users to choose an option
    static void AppMenu(int proName, int Qty, double Price, Product[] shop, int in, char x)
    {   
        do
        {
            System.out.println("Application Menu" + "\n");
            System.out.println("1. Display all Items");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. Re-Price a Stock Item");
            System.out.println("5. Display the total Stock value");
            System.out.println("6. Exit App" + "\n");
            System.out.print("Select the option you want to continue with from the Menu : ");
            in = kbd.nextInt();
            System.out.println("\n");
            
            switch(in)
            {
                case 1:
                System.out.println("1. Product List");
                displayProducts(shop);
                break;

                case 2:
                buyStockMethod(proName, Qty, shop, in, x);
                break;

                case 3:
                sellStock(proName, Qty, shop, in, x);
                break;

                case 4:
                setPrice(proName, Price, shop, in, x);
                break;

                case 5:
                totalStockVal(shop);
                break;

                case 6:
                System.out.println("The app has now been exited.");
                break;

                default:
                System.out.println("--- Please Enter a valid Number! ---");
                System.out.println("\n");
                break;
            }
        }while(in != 6);

    }

// method to display products
    static void displayProducts(Product[] shop)
    {
        System.out.println("\n");
            for(int i = 0; i < shop.length;i++)
            {
                System.out.println((i+1)+". "+shop[i].getName()+" [ Stock: "+shop[i].getStockLevel()+" ] Price: £"+shop[i].getPrice());
            }
        System.out.println("\n");
    }

// method to buy the stock
    static void buyStockMethod(int ProNameIn, int QtyIn, Product[] shopIn, int inp, char reply)
    {
        System.out.println();
        System.out.println("2. Buy Stock");
        displayProducts(shopIn);
        
        do
        {
            
            System.out.print("Enter the product you want to buy: ");
            ProNameIn = kbd.nextInt();
            while(ProNameIn < 1 || ProNameIn > 5)
            {
                System.out.print("Invalid Input! Please enter a valid Product: ");
                ProNameIn = kbd.nextInt();
            }

            if(ProNameIn == 1)
            inp = 0;

            else if(ProNameIn == 2)
            inp = 1;

            else if(ProNameIn == 3)
            inp = 2;

            else if(ProNameIn == 4)
            inp = 3;

            else if(ProNameIn == 5)
            inp = 4;

            System.out.println();
            System.out.println((inp+1)+". Name: "+shopIn[inp].getName()+" | Stock: "+shopIn[inp].getStockLevel());

            System.out.print("Enter the quantity to be bought: ");
            QtyIn = kbd.nextInt();

            shopIn[inp].buyStock(QtyIn);
            System.out.println();
            System.out.println("The New Stock is " + shopIn[inp].getStockLevel());
            System.out.println("The New Value of the stock is £" + shopIn[inp].getPrice()*shopIn[inp].getStockLevel());
            System.out.println("\n");
            System.out.print("Would you like to buy the stock of another Product? (y/n): ");
            reply = kbd.next().charAt(0);
            reply = Character.toLowerCase(reply);

            while(reply != 'y' && reply != 'n')
            {
                System.out.print("Invalid Input! Please enter either 'y' for 'Yes' or 'n' for 'No': ");
                reply = kbd.next().charAt(0);
                reply = Character.toLowerCase(reply);
            }
        }while(reply == 'y');
        System.out.println("\n");
    }

// method to sell the stock
    static void sellStock(int ProNameN, int QtyN, Product[] shopIn, int inp, char reply1)
    {
        System.out.println();
        System.out.println("3. Sell Stock");
        displayProducts(shopIn);
        
        do
        {
            System.out.print("Enter the product Sold: ");
            ProNameN = kbd.nextInt();
            while(ProNameN < 1 || ProNameN > 5)
            {
                System.out.print("Invalid Input! Please enter a valid Product: ");
                ProNameN = kbd.nextInt();
            }

            if(ProNameN == 1)
            inp = 0;

            else if(ProNameN == 2)
            inp = 1;

            else if(ProNameN == 3)
            inp = 2;

            else if(ProNameN == 4)
            inp = 3;

            else if(ProNameN == 5)
            inp = 4;

            System.out.println();
            System.out.println((inp+1)+". Name: "+shopIn[inp].getName()+" | Stock: "+shopIn[inp].getStockLevel());
            System.out.print("Enter the quantity Sold: ");
            QtyN = kbd.nextInt();

            shopIn[inp].sell(QtyN);
            System.out.println();
            System.out.println("The updated Stock is "+shopIn[inp].getStockLevel());
            System.out.println();
            System.out.print("Would you like to sell another Product? (y/n): ");
            reply1 = kbd.next().charAt(0);
            reply1 = Character.toLowerCase(reply1);

            while(reply1 != 'y' && reply1 != 'n')
            {
                System.out.print("Invalid Input! Pleae enter either 'y' for 'Yes' or 'n' for 'No': ");
                reply1 = kbd.next().charAt(0);
                reply1 = Character.toLowerCase(reply1);
            }
        
        }while(reply1 == 'y');
        System.out.println("\n");
    }

// method to set new price for the stock
    static void setPrice(int ProNameN, double PriceN, Product[] shopIn, int inp, char reply2)
    {
        System.out.println();
        System.out.println("4. Re-Price a Stock Item");
        displayProducts(shopIn);
        
        do
        {
            System.out.print("Enter the product to change price: ");
            ProNameN = kbd.nextInt();
            while(ProNameN < 1 || ProNameN > 5)
            {
                System.out.print("Invalid Input, Enter valid Product: ");
                ProNameN = kbd.nextInt();
            }

            if(ProNameN == 1)
            inp = 0;

            else if(ProNameN == 2)
            inp = 1;

            else if(ProNameN == 3)
            inp = 2;

            else if(ProNameN == 4)
            inp = 3;

            else if(ProNameN == 5)
            inp = 4;

            System.out.println();
            System.out.println((inp+1)+". Name: "+shopIn[inp].getName()+" | Price: £"+shopIn[inp].getPrice());

            System.out.print("Enter the new price of the Product: £");
            PriceN = kbd.nextDouble();

            shopIn[inp].setPrice(PriceN);
            System.out.println();
            System.out.println("The New Price is £"+shopIn[inp].getPrice());
            System.out.println();
            System.out.print("Would you like change the price of another Product? (y/n): ");
            reply2 = kbd.next().charAt(0);
            reply2 = Character.toLowerCase(reply2);

            while(reply2 != 'y' && reply2 != 'n')
            {
                System.out.print("Invalid Input Enter Either 'y' for 'Yes' or 'n' for 'No': ");
                reply2 = kbd.next().charAt(0);
                reply2 = Character.toLowerCase(reply2);
            }
        
        }while(reply2 == 'y');
        System.out.println("\n");    

    }

// method to calculate total monetary value of the existing stock
    static void totalStockVal(Product[] shopIn)
    {
        double totalStockVal = 0;

        System.out.println();
        System.out.println("5. Total Stock Value");
        System.out.println();
        for(int i = 0; i < shopIn.length; i++)
        {
        totalStockVal += shopIn[i].getPrice()*shopIn[i].getStockLevel();
        }
        System.out.println("The total Stock Value is: £"+ totalStockVal);
        System.out.println("\n");
    }
}