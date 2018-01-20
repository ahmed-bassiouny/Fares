package ahmed.bassiouny.fares.interfaces;

import ahmed.bassiouny.fares.model.Product;

/**
 * Created by bassiouny on 20/01/18.
 */

public interface MyProductInterface {
    int VIEW = 1;
    int EDIT = 2;
    int DELETE = 3;

    void operationProduct(Product product, int operation);
}
