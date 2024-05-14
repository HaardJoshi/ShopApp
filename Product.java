public class Product
{
    private String name;
	private int stockLevel;
	private double price;

// the constructor
    public Product( String nameIn, int stockLevelIn, double priceIn)
    {
        name = nameIn;
        stockLevel = stockLevelIn;
        price = priceIn;
    }

//method to buy the stock
    public double buyStock(int stockIn)
    {
        stockLevel += stockIn;
        return stockIn * price;
    }

// method to sell the stock
    public boolean sell(int stockIn)
    {
        if (stockLevel > stockIn) 
        {
            return true;
        }else
            {
                return false;
            }
    }

// method to set new price for the stock
    public void setPrice(double priceIn)
    {
        price = priceIn;
    }

//method to display the product name
    public String getName()
    {
        return name;
    }

// method to display the stock
    public int getStockLevel()
    {
        return stockLevel;
    }

//method to display the product price
    public double getPrice()
    {
        return price;
    }
}