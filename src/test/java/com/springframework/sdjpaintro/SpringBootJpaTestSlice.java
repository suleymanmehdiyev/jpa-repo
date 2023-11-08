package com.springframework.sdjpaintro;

import com.springframework.sdjpaintro.domain.Book;
import com.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.springframework.sdjpaintro.bootstrap"})
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

@Commit
    @Order(1)
    @Test
    void testJpaTestSlice(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("MyBook","1234","Self"));

//        long countAfter = bookRepository.count();
//
//        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSliceTransaction(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);


    }
}
