package hs.game.snakeback.Service;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hs.game.snakeback.Entity.Snake;
import hs.game.snakeback.Repository.SnakeRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class SnakeServiceImplTests {
    @Autowired
    SnakeRepository srepo;

    @Test
    void testRegister() {
        Snake dummy = Snake.builder().pid(1L).name("dummy1").email("aaa@aaa.com").topconsum(150L).build();
        srepo.save(dummy);
    }

    @Test
    void testLotsOfRegistering(){
        IntStream.rangeClosed(1, 50).forEach(e->{
            Snake dummy = Snake.builder().name("dummy"+e).email(e+"aaa@aaa.com").topconsum(150L).build();
            srepo.save(dummy);
        });
    }

    @Test
    void getList(){
        srepo.findAll().forEach(e->{
            System.out.println(e);

        });
    }

    @Test
    void deleteUser(){
        Snake who = srepo.getReferenceById(1L);
        srepo.delete(who);
    }
}
