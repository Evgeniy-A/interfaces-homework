package homework_exception;

public class EmptyMemberArrayException extends RuntimeException {
    public EmptyMemberArrayException() {
        super("Пользователи ещё не были добавлены");
    }
}
