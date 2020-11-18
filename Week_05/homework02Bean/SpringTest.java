package fx.gxs.week05.homework02Bean;

import fx.gxs.week05.School;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-16 17:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTest {

    @Autowired
    Address address;

    @Autowired
    People people;

    @Autowired
    School school;

    @Test
    public void method01() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        People people = context.getBean("people", People.class);
//        System.out.println(people);
//        Address address = context.getBean("address",Address.class);
//        Address address2 = context.getBean("address2",Address.class);
//        System.out.println(address == address2);
        System.out.println(school);
    }
}
