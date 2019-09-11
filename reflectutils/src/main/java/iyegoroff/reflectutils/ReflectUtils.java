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

  public static @Nullable <T> T getFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    String name
  ) {
    return getFieldValue(type, target, name, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static @Nullable <T> T getFieldValue(@NonNull Object target, String name, String logTag) {
    return getFieldValue(target.getClass(), target, name, logTag);
  }

  @SuppressWarnings({"unchecked", "WeakerAccess"})
  public static @Nullable <T> T getFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    String name,
    String logTag
  ) {
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

  public static <T> void setFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    String name,
    T value
  ) {
    setFieldValue(type, target, name, value, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static <T> void setFieldValue(
    @NonNull Object target,
    String name,
    T value,
    String logTag
  ) {
    setFieldValue(target.getClass(), target, name, value, logTag);
  }

  @SuppressWarnings("WeakerAccess")
  public static <T> void setFieldValue(
    @NonNull Class<?> type,
    @NonNull Object target,
    String name,
    T value,
    String logTag
  ) {
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

  public static @Nullable <T> T invokeMethod(
    @NonNull Class<?> type,
    @NonNull Object target,
    String name
  ) {
    return invokeMethod(type, target, name, TAG);
  }

  @SuppressWarnings("WeakerAccess")
  public static @Nullable <T> T invokeMethod(@NonNull Object target, String name, String logTag) {
    return invokeMethod(target.getClass(), target, name, logTag);
  }

  @SuppressWarnings({"unchecked", "WeakerAccess"})
  public static @Nullable <T> T invokeMethod(
    @NonNull Class<?> type,
    @NonNull Object target,
    String name,
    String logTag
  ) {
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
