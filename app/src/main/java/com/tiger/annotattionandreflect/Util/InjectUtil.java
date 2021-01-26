package com.tiger.annotattionandreflect.Util;

import android.app.Activity;
import android.view.View;

import com.tiger.annotattionandreflect.annotation.BindView;

import java.lang.reflect.Field;

public class InjectUtil {
    public static void inject(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field: declaredFields) {
            if (field.isAnnotationPresent(BindView.class)){
                BindView annotation = field.getAnnotation(BindView.class);
                int viewID = annotation.value();
                View view = activity.findViewById(viewID);
                field.setAccessible(true);
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
