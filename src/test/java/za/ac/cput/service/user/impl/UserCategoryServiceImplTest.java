package za.ac.cput.service.user.impl;
/*
  Adecel Rusty Mabiala
  219197229
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.factory.user.UserCategoryFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserCategoryServiceImplTest {

    @Autowired
    private UserCategoryServiceImpl userCategoryService;
    private static UserCategory userCategory_a =
            UserCategoryFactory.build(10,"Employee",
                    "Employee who take care of luggage");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        UserCategory userCategory = userCategoryService.save(userCategory_a);
        assertNotNull(userCategory);
    }

    @Test
    @Order(2)
    void read() {
        Optional<UserCategory> read = this.userCategoryService.read(String.valueOf(10));
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals(10, userCategory_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.userCategoryService.delete(userCategory_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.userCategoryService.deleteById(String.valueOf(10));
    }

    @Test
    @Order(3)
    void findAll() {
    }
}