/*
1. Understanding Asymptotic Notation

Big O notation is a mathematical way of expressing how the running time or memory usage of an algorithm grows as the input size (n) increases.

It helps us:
- Compare different algorithms.
- Predict performance on large datasets.
- Choose the most efficient algorithm.

Eg:
O(1) – Constant time
O(log n) – Logarithmic time
O(n) – Linear time
O(n log n) – Linearithmic time
O(n²) – Quadratic time


Search Operation Cases
Best Case
The item is found immediately.
Linear Search → O(1)
Binary Search → O(1)

Average Case
The item is somewhere in the middle.
Linear Search → O(n)
Binary Search → O(log n)

Worst Case
The item is the last element or does not exist.
Linear Search → O(n)
Binary Search → O(log n)

*/

class Product
{
    int productId;
    String productName, category;

    Product(int productId, String productName, String category)
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display()
    {
        System.out.println("Product ID: "+productId+"\nProduct Name: "+productName+"\nProduct Category: "+category);
    }
}

public class ECommerceSearch
{
    public static Product linearSearch(Product[] products, int key)
    {
        for(Product product : products)
        {
            if(product.productId==key)
            {
                return product;
            }
        }
        return null;
    }

    public static Product[] sortProducts(Product[] products)
    {
        for(int i=0; i<products.length-1; i++)
        {
            for(int j=0; j<products.length-i-1; j++)
            {
                if(products[j+1].productId<products[j].productId)
                {
                    Product temp = products[j+1];
                    products[j+1] = products[j];
                    products[j] = temp;
                }
            }
        }
        return products;
    }

    public static Product binarySearch(Product[] products, int key)
    {
        products = sortProducts(products);

        int l = products.length;
        int low=0, high=l-1;

        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(products[mid].productId == key)
                return products[mid];

            else if(products[mid].productId < key)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return null;
    }
    public static void main(String[]args)
    {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(146, "Shoes", "Fashion"),
            new Product(153, "Watch", "Accessories"),
            new Product(104, "Phone", "Electronics"),
            new Product(176, "Book", "Education")
        };

        int searchId = 104;
        System.out.println("Linear Search:");
        Product result = linearSearch(products, searchId);
        if(result!=null)
            result.display();
        else
            System.out.println("Product not found.");

        System.out.println("\nBinary Search:");
        result = binarySearch(products, searchId);
        if(result!=null)
            result.display();
        else
            System.out.println("Product not found.");
    }
}