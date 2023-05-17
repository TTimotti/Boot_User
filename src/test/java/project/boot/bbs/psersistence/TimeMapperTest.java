package project.boot.bbs.psersistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import project.boot.bbs.mapper.UserMapper;

@Slf4j
@SpringBootTest
public class TimeMapperTest {

    @Autowired
    private UserMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info("timeMapper class name: " + timeMapper.getClass().getName());
        log.info("timeMapper time: " + timeMapper.getTime());
    }
}
