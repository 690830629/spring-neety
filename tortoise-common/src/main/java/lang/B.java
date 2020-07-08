package lang;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanglei105
 * @version 1.0
 * @date 2020/7/3 下午4:52
 */
@Data
public class B {
    private int age;

    private String name;

    public static void main(String[] args) {
        List<A> aList=new ArrayList<A>();
        A a = new A();
        a.setName("A");
        B b = new B();
        b.setAge(10);
        b.setName("BBB");
        List<B> listB = new ArrayList<B>();
        B b1 = new B();
        b1.setAge(11);
        b1.setName("BBB");
        listB.add(b);
        listB.add(b1);
        a.setListB(listB);
        aList.add(a);
        System.out.println(aList.toString());
        aList.stream().forEach(e -> e.setListB(e.getListB().stream().filter(i -> i.getAge() == 8).collect(Collectors.toList())) );
        System.out.println(aList.toString());

        Integer fff = listB.stream().map(e -> e.getAge()).reduce(Integer::sum).get();
        System.out.println(fff);

    }


}
