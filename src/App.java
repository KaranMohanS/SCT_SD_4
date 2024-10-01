import product.productDetails;
import product.productService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println(
                "Enter Option : 1 Add Product || 2 View Product || 3 Get Product Details || 4 Delete Product || 5 Update Product || 6 exit");
        int Option = productDetails.scaner.nextInt();
        productDetails.scaner.nextLine();

        switch (Option) {
            case 1:
                productService.addproduct();
                break;
            case 2:
                productService.viewProducts();
                break;
            case 3:
                productService.getproduct();
                break;
            case 4:
                productService.Deleteproduct();
                break;
            case 5:
                productService.updateProduct();
                break;
            case 6:
                break;
            default:
                throw new Exception("Invalid Option: "+Option);
        }

        
    }
}
