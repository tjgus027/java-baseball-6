package baseball.exception;

public class InvalidInputException extends IllegalArgumentException{
    private static final String MESSAGE = "잘못된 입력값입니다.";

    public InvalidInputException() {
        super(MESSAGE);
    }
}
