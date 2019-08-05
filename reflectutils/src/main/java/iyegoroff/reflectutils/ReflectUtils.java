package iyegoroff.reflectutils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class ReflectUtils {

  private static String TAG = "ReactNative";

  public static @Nullable <T> T getFieldValue(@NonNull Object target, String name) {
    return getFieldValue(target, name, TAG);
  }

  @SuppressWarnings({"unchecked", "WeakerAccess"})
  public static @Nullable <T> T getFieldValue(@NonNull Object target, String name, String logTag) {
    Class<?> type = target.getClass();

    try {
      Field field = type.getDeclaredField(name);
      field.setAccessible(true);

      return (T) field.get(target);

    } catch (Exception e) {
      Log.w(logTag, "Can't get " + type.getName() + " field " + name);
      Log.w(logTag, e.getMessage() == null ? "" : e.getMessage());
    }

    return null;
  }

  public static <T> void setFieldValue(@NonNull Object target, String name, T value) {
    setFieldValue(target, name, value, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static <T> void setFieldValue(@NonNull Object target, String name, T value, String logTag) {
    Class<?> type = target.getClass();

    try {
      Field field = type.getDeclaredField(name);
      field.setAccessible(true);
      field.set(target, value);

    } catch (Exception e) {
      Log.w(logTag, "Can't set " + type.getName() + " field " + name);
      Log.w(logTag, e.getMessage() == null ? "" : e.getMessage());
    }
  }

  public static @Nullable <T> T invokeMethod(@NonNull Object target, String name) {
    return invokeMethod(target, name, TAG);
  }

  @SuppressWarnings({"unchecked", "WeakerAccess"})
  public static @Nullable <T> T invokeMethod(@NonNull Object target, String name, String logTag) {
    Class<?> type = target.getClass();

    try {
      Method method = type.getDeclaredMethod(name);
      method.setAccessible(true);

      return (T) method.invoke(target);

    } catch (Exception e) {
      Log.w(logTag, "Can't invoke " + type.getName() + " method " + name);
      Log.w(logTag, e.getMessage() == null ? "" : e.getMessage());
    }

    return null;
  }
}
