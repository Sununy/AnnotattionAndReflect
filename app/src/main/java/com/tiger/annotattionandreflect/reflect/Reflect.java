package com.tiger.annotattionandreflect.reflect;

import android.app.Activity;
import android.util.Log;

import com.tiger.annotattionandreflect.MainActivity;

public class Reflect {


    private static final String TAG = "Tiger";

    static {
        Log.d(TAG, "static code executed");
    }

    public void testClass() {
        //获取class的方式一 类名.class
        Class<String> aClass = String.class;

        //获取class的方式二 对象.getClass()
        String s = new String();
        Class<? extends String> aClass1 = s.getClass();

        //方式三 Class.forName(类的完整路径)
        //会将class加载到JVM中 并对类进行解释初始化， 那么类里面的静态代码块也会执行
        try {
            Class<?> bClass = Class.forName("com.tiger.annotattionandreflect.MainActivity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方式四 ClassLoader.loadClass(类的完整路径)
        //只将类加载到JVM中 但不会解释 不初始化 静态的代码块不会执行
        //只有在class。newInstance（）的时候才会初始化
        try {
            Class<?> cClass = ClassLoader.getSystemClassLoader().loadClass("com.tiger.annotattionandreflect.MainActivity");
            Object o = cClass.newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
