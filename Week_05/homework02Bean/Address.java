package fx.gxs.week05.homework02Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-16 17:13
 */
@Data
@AllArgsConstructor
@ToString
//@Component
public class Address {

    private String province;

    private String city;

    public Address() {
        System.out.println("init");
    }
}
