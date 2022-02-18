import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(1, "Adventures of Tom Sawyer", 100, "Mark Twain");
    private Product book2 = new Book(2, "Treasure Island", 150, "Robert Louis Stevenson");
    private Product book3 = new Book(3, "Alice in Wonderland", 130, "Lewis Carroll");
    private Product smartphone1 = new Smartphone(4, "3310", 1000, "Nokia");
    private Product smartphone2 = new Smartphone(5, "Galaxy", 1200, "Samsung");
    private Product smartphone3 = new Smartphone(6, "Xperia", 1150, "Sony");
    private Product book4 = new Book(7, "Treasure Island", 140, "Robert Louis Stevenson");
    private Product smartphone4 = new Smartphone(8, "Xperia", 1200, "Sony");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(book4);
        manager.add(smartphone4);
    }

    @Test
    void add() {
        Product[] expected = new Product[]{book1, book2, book3, smartphone1, smartphone2, smartphone3, book4, smartphone4};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBook() {
        Product[] expected = new Product[]{book2, book4};
        Product[] actual = manager.searchBy("Treasure Island");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphone() {
        Product[] expected = new Product[]{smartphone3, smartphone4};
        Product[] actual = manager.searchBy("Xperia");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNoProduct() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Note");

        assertArrayEquals(expected, actual);
    }
}