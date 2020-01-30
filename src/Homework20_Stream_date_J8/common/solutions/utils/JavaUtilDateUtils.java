package Homework20_Stream_date_J8.common.solutions.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class JavaUtilDateUtils {

  private static final String PATTERN = "dd.MM.yyyy";

  private JavaUtilDateUtils(){

  }

  public static LocalDate valueOf(String dateStr, String pattern) throws ParseException {
    return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
  }

  public static LocalDate valueOf(String dateStr) throws ParseException {
    return valueOf(dateStr, PATTERN);
  }

}
