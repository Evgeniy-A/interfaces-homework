package homework_exception;

public class InvalidDateRangeException extends RuntimeException {
  public InvalidDateRangeException() {
    super("Дата выбрана неверно");
  }
}
