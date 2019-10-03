package iyegoroff.reflectutils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class ReflectUtils {

  private static String TAG = "ReactNative";

  public static @Nullable <T> T getFieldValue(
    @NonNull String className,
    @NonNull Object target,
    @NonNull String name
  ) {
    return getFieldValue(className, target, name, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static @Nullable <T> T getFieldValue(
    @NonNull String className,
    @NonNull Object target,
    @NonNull String name,
    @NonNull String logTag
  ) {
    try {
      return getFieldValue(Class.forName(className), target, name, logTag);

    } catch (ClassNotFoundException e) {
      Log.w(logTag, "Can't find " + className + " class");
      Log.e(logTag, e.getMessage() == null ? "" : e.getMessage());
      e.printStackTrace();
    }

    return null;
  }

  public static @Nullable <T> T getFieldValue(@NonNull Object target, @NonNull String name) {
    return getFieldValue(target, name, TAG);
  }

  public static @Nullable <T> T getFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    @NonNull String name
  ) {
    return getFieldValue(type, target, name, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static @Nullable <T> T getFieldValue(
    @NonNull Object target,
    @NonNull String name,
    @NonNull String logTag
  ) {
    return getFieldValue(target.getClass(), target, name, logTag);
  }

  @SuppressWarnings({"unchecked", "WeakerAccess"})
  public static @Nullable <T> T getFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    @NonNull String name,
    @NonNull String logTag
  ) {
    try {
      Field field = type.getDeclaredField(name);
      field.setAccessible(true);

      return (T) field.get(target);

    } catch (Exception e) {
      Log.w(logTag, "Can't get " + type.getName() + " field " + name);
      Log.e(logTag, e.getMessage() == null ? "" : e.getMessage());
      e.printStackTrace();
    }

    return null;
  }

  public static <T> void setFieldValue(
    @NonNull String className,
    @NonNull String name,
    @Nullable T value
  ) {
    setFieldValue(className, name, value, TAG);
  }

  public static <T> void setFieldValue(
    @NonNull String className,
    @NonNull Object target,
    @NonNull String name,
    @Nullable T value,
    @NonNull String logTag
  ) {
    try {
      setFieldValue(Class.forName(className), target, name, value, logTag);

    } catch (ClassNotFoundException e) {
      Log.w(logTag, "Can't find " + className + " class");
      Log.e(logTag, e.getMessage() == null ? "" : e.getMessage());
      e.printStackTrace();
    }
  }

  public static <T> void setFieldValue(
    @NonNull Object target,
    @NonNull String name,
    @Nullable T value
  ) {
    setFieldValue(target, name, value, TAG);
  }

  public static <T> void setFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    @NonNull String name,
    @Nullable T value
  ) {
    setFieldValue(type, target, name, value, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static <T> void setFieldValue(
    @NonNull Object target,
    @NonNull String name,
    @Nullable T value,
    @NonNull String logTag
  ) {
    setFieldValue(target.getClass(), target, name, value, logTag);
  }

  @SuppressWarnings("WeakerAccess")
  public static <T> void setFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    @NonNull String name,
    @Nullable T value,
    @NonNull String logTag
  ) {
    try {
      Field field = type.getDeclaredField(name);
      field.setAccessible(true);
      field.set(target, value);

    } catch (Exception e) {
      Log.w(logTag, "Can't set " + type.getName() + " field " + name);
      Log.e(logTag, e.getMessage() == null ? "" : e.getMessage());
      e.printStackTrace();
    }
  }

  public static @Nullable <T> T invokeMethod(
    @NonNull String className,
    @NonNull Object target,
    @NonNull String name,
    Object... args
  ) {
    return invokeMethod(className, target, name, TAG, args);
  }

  @SuppressWarnings("WeakerAccess")
  public static @Nullable <T> T invokeMethod(
    @NonNull String className,
    @NonNull Object target,
    @NonNull String name,
    @NonNull String logTag,
    Object... args
  ) {
    try {
      return invokeMethod(Class.forName(className), target, name, TAG, args);

    } catch (ClassNotFoundException e) {
      Log.w(logTag, "Can't find " + className + " class");
      Log.e(logTag, e.getMessage() == null ? "" : e.getMessage());
      e.printStackTrace();
    }

    return null;
  }

  public static @Nullable <T> T invokeMethod(
    @NonNull Object target,
    @NonNull String name,
    Object... args
  ) {
    return invokeMethod(target, name, TAG, args);
  }

  public static @Nullable <T> T invokeMethod(
    @NonNull Class<?> type,
    @NonNull Object target,
    @NonNull String name,
    Object... args
  ) {
    return invokeMethod(type, target, name, TAG, args);
  }

  @SuppressWarnings("WeakerAccess")
  public static @Nullable <T> T invokeMethod(
    @NonNull Object target,
    @NonNull String name,
    @NonNull String logTag,
    Object... args
  ) {
    return invokeMethod(target.getClass(), target, name, logTag, args);
  }

  @SuppressWarnings({"unchecked", "WeakerAccess"})
  public static @Nullable <T> T invokeMethod(
    @NonNull Class<?> type,
    @NonNull Object target,
    @NonNull String name,
    @NonNull String logTag,
    Object... args
  ) {
    try {
      Method method = type.getDeclaredMethod(name);
      method.setAccessible(true);

      //noinspection JavaReflectionInvocation
      return (T) method.invoke(target, args);

    } catch (Exception e) {
      Log.w(logTag, "Can't invoke " + type.getName() + " method " + name);
      Log.e(logTag, e.getMessage() == null ? "" : e.getMessage());
      e.printStackTrace();
    }

    return null;
  }
}
