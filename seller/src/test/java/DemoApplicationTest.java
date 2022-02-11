
import com.example.seller.SellerApplication;

import com.example.seller.dao.OssDao;
import com.example.seller.dao.UserDao;
import com.example.seller.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest(classes = SellerApplication.class)
class DemoApplicationTest {
    @Autowired
    private OssDao ossDao;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDao userDao;
    @Test
    void test() {
        /*ossDao.upLoad(new File("/home/lwy/下载/aaa/warnning/seller/src/main/resources/image/select.png"));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");*/
        //userDao.create("aa","www","111");
        //userService.findByNameAndPassword("aa","www");
        userService.findByName("aa");
        //userDao.deleteByName("aa");
    }

}
