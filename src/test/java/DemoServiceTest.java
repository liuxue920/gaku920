import com.fafamc.gaku.dao.TestDao;
import com.fafamc.gaku.domain.TTest;
import com.fafamc.gaku.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(DemoService.class)
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService;

    @Mock
    private TestDao testDao;

    @Test
    public void testService_TEST() {
        TTest tTestDomain = new TTest();
        tTestDomain.setId(1L);
        tTestDomain.setName("zhangsan");
        tTestDomain.setTime(LocalDateTime.now());
        Mockito.when(testDao.selectByPrimaryKey(Mockito.any())).thenReturn(tTestDomain);

        TTest t = demoService.testServiceMothed(5L);
        Assert.assertEquals("zhangsan",t.getName());

        Assert.assertEquals(Long.valueOf(1L),t.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testPrivate_TEST()  {
        System.out.println("123");
        throw new RuntimeException("123");
    }

    @Test
    public void testStatic_TEST(){
        Assert.assertEquals("123",DemoService.testStatic());
    }
}
