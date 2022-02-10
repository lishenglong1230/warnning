
import com.example.seller.SellerApplication;

import com.example.seller.dao.OssDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest(classes = SellerApplication.class)
class DemoApplicationTest {
    @Autowired
    private OssDao ossDao;
    @Test
    void test() {
        ossDao.upLoad(new File("/home/lwy/下载/aaa/warnning/seller/src/main/resources/image/select.png"));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");

    }

}
