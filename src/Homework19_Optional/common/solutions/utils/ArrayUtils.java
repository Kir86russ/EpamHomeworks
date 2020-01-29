package Homework19_Optional.common.solutions.utils;

import java.util.Optional;

public final class ArrayUtils {

  private ArrayUtils() {
  }

  public static void copyArray(Object[] src, Object[] dest) {
    System.arraycopy(src, 0, dest, 0, src.length);
  }

  public static void printArray(Object[] arr) {
    for (Object obj : arr) {
      Optional.ofNullable(obj).ifPresent(System.out::println);
    }
  }

  public static void removeElement(Object[] arr, int index) {
    System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
  }

}