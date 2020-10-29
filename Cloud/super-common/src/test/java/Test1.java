import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 * StackTraceElement
 *
 * 在统一异常处理中使用该打印方式，可以得到类似链路打印一样
 */
public class Test1 {

    public static void main(String[] args) {
        new A().TestA();

        Map aaa = new HashMap<>(10);
        System.out.println(aaa.size());

    }

    public void TestInvoke(Exception e){
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for(StackTraceElement s:stackTraceElements){
            System.out.println(
                    "方法名："+s.getMethodName()+
                    ",类名："+s.getClassName()+
                    ",行数："+s.getLineNumber()+
                    ",文件名："+s.getFileName()+s
            );
        }
    }

}
class A{
    public void TestA(){
        new B().TestB();
    }
}

class B{
    public void TestB(){
        new Test1().TestInvoke(new NullPointerException());
    }
}