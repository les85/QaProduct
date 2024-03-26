import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void removeWhenProductExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1,"телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3,"мащина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductNotExistTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1,"телефон", 30_000);
        Product product2 = new Product(2, "книга", 300);
        Product product3 = new Product(3,"мащина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4444)
        );
    }

}