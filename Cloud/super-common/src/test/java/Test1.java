/**
 * 测试
 * StackTraceElement
 */
public class Test1 {

    public static void main(String[] args) {
        new A().TestA();
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