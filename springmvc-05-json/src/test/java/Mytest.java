import com.kuang.pojo.Orders;
import com.kuang.pojo.Product;
import com.kuang.service.OrdersService;
import com.kuang.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class Mytest {

    @Test
    public void  test3() throws Exception
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService)context.getBean("ProductServiceImpl");
        Product productById = productService.findProductById(1);
        System.out.println(productById.getDepartureTime());
    }




}
