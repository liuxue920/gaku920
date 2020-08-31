import com.fafamc.Starter;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootTest {

    @Value("${spring.datasource.password}")
    private String testname;

    @Before
    public void before() throws Exception {

    }

    @Test
    public void test() throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(testname);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }

    @Autowired
    private StringEncryptor stringEncryptor;
    @Test
    public void test2() {
        String lx = stringEncryptor.encrypt("redis_p@ssw0rd");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(lx);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


}
