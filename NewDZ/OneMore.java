import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;


public class OneMore {
    public static void main(String args[]) throws Exception
    {

        ControlWork obj = new ControlWork();


        Class cls = obj.getClass();
        System.out.println("什么是什么 " +
                cls.getName());


        Constructor constructor = cls.getConstructor();
        System.out.println("什么是什么 " +
                constructor.getName());

        System.out.println("什么是什么 : ");


        Method[] methods = cls.getMethods();

        for (Method method:methods)
            System.out.println(method.getName());


        Method methodcall1 = cls.getDeclaredMethod("能2", int.class);


        methodcall1.invoke(obj, 20);


        Field field = cls.getDeclaredField("我");


        field.setAccessible(true);


        field.set(obj, "什么");



        Method methodcall2 = cls.getDeclaredMethod("能1");


        methodcall2.invoke(obj);


        Method methodcall3 = cls.getDeclaredMethod("能3");


        methodcall3.setAccessible(true);

        methodcall3.invoke(obj);
    }
}
