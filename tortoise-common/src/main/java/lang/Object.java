package lang;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

public class Object {
    private String age;

    public static void main(String[] args)  {
       Double a=0.01D;
       Double b=0.02D ;
        System.out.println(a.intValue()<b.intValue());
        System.out.println(new BigDecimal(a).compareTo(new BigDecimal(b)));
        System.out.println(a>0);

    }
}
