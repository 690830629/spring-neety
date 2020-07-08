package lang;

import lombok.Data;

import java.util.List;

/**
 * @author wanglei105
 * @version 1.0
 * @date 2020/7/3 下午4:52
 */
@Data
public class A {
    private String name;

    private List<B>  listB;
}
