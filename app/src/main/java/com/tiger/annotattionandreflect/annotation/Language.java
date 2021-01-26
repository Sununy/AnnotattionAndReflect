package com.tiger.annotattionandreflect.annotation;

import android.provider.ContactsContract;

import com.tiger.annotattionandreflect.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.annotation.IntDef;

@IntDef({Constants.CHINESES,Constants.ENGLISH,Constants.JAPAN,Constants.POLISH})
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface Language {

}
