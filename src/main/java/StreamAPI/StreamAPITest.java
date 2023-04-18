package StreamAPI;

import MethodRefrence.Employee;
import MethodRefrence.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 大星
 * @date 2023/04/18 15:07
 **/

public class StreamAPITest {

    //创建 Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //map的遍历
        Map<Integer , Integer> map = new HashMap<>();
        map.put(1,1);map.put(2,2);map.put(3,3);map.put(4,4);
        map.keySet().forEach(System.out::println);
        System.out.println("************");
        map.values().forEach(System.out::println);
        System.out.println("************");
        map.entrySet().forEach(System.out::println);

//        default Stream<E> stream() : 返回一个顺序流，顺序流等会中间操作拿数据的时候按顺序拿
        Stream<Employee> stream = employees.stream();

//        default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }

    //创建 Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }
    //创建 Stream方式三：通过Stream的of()，通过显示值创建一个流。它可以接收任意数量的参数
    @Test
    public void test3(){

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建 Stream方式四：创建无限流【用的少，了解下就行】
    @Test
    public void test4(){

//      迭代
//      public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);


//      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}

