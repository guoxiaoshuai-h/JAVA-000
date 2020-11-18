package fx.gxs.week05.homework02Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-16 17:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class People {

    private int age;

    private String name;

    @Autowired
    private Address address;

}
