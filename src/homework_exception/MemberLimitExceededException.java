package homework_exception;

public class MemberLimitExceededException extends RuntimeException {
    public MemberLimitExceededException() {
        super("Количество пользователей исчерпано");
    }
}
