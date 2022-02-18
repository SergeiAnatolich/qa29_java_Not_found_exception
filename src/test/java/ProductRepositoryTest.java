import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book = new Book();
    private Book book1 = new Book(1, "Adventures of Tom Sawyer", 100, "Mark Twain");
    private Book book2 = new Book(2, "Treasure Island", 150, "Robert Louis Stevenson");
    private Book book3 = new Book(3, "Alice in Wonderland", 130, "Lewis Carroll");
    private Smartphone smartphone = new Smartphone();
    private Smartphone smartphone1 = new Smartphone(4, "3310", 1000, "Nokia");
    private Smartphone smartphone2 = new Smartphone(5, "Galaxy", 1200, "Samsung");
    private Smartphone smartphone3 = new Smartphone(6, "Xperia", 1150, "Sony");

    @Test
    public void shouldSaveOneBook() {
        repository.save(book);

        Product[] expected = new Product[]{book};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneSmartphone() {
        repository.save(smartphone);

        Product[] expected = new Product[]{smartphone};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveTwoProduct() {
        repository.save(book);
        repository.save(smartphone);

        Product[] expected = new Product[]{book, smartphone};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(2);
        repository.removeById(5);

        Product[] expected = new Product[]{book1, book3, smartphone1, smartphone3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNotId() {

        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        assertThrows(NotFoundException.class, () -> repository.removeById(3));
    }
}