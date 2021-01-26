package com.tiger.annotattionandreflect;


import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tiger.annotattionandreflect.Util.InjectUtil;
import com.tiger.annotattionandreflect.annotation.BindView;
import com.tiger.annotattionandreflect.annotation.Food;
import com.tiger.annotattionandreflect.annotation.Language;

@Food(value = "Lion", day = 1)
public class MainActivity extends AppCompatActivity {

    @Language
    private int mLanguage;

    @BindView(R.id.hello)
    TextView tvHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setChooseLanguage(Constants.CHINESES);
        InjectUtil.inject(this);
        tvHello.setText("Tiger is learning");
        testClass();
    }

    /**
     * SOURCE级别的注解用来语法的检查
     * @param language
     */
    public void setChooseLanguage(@Language int language){
        mLanguage = language;
    }


    public void testClass(){
        //获取class的方式一 类名.class
        Class<String> aClass = String.class;

        //获取class的方式二 对象.getClass()
        String s = new String();
        Class<? extends String> aClass1 = s.getClass();

        //方式三 Class.forName(类的完整路径)
        try {
            Class<?> bClass = Class.forName("com.tiger.annotattionandreflect.reflect.Reflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方式四 ClassLoader.loadClass(类的完整路径)
        try {
            Class<?> cClass = ClassLoader.getSystemClassLoader().loadClass("com.tiger.annotattionandreflect.reflect.Reflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
