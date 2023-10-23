package baseball.controller;

import baseball.exception.InvalidInputException;
import baseball.utils.OUTPUTMESSAGE;
import baseball.utils.ResultType;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputController {
    private static final String RESATRT_VALUE = "1";
    private static final String END_VALUE = "2";
    private InputController() {
    }

    public static String getResult(List<Integer> target, String inputValue) throws IllegalArgumentException{
        int[] scores = checkValue(target, inputValue);
        StringBuilder sb = new StringBuilder();

        if (scores[0] == 0 && scores[1] == 0) return ResultType.NOTHING.toString();

        if (scores[0] > 0){
            sb.append(scores[0]).append(ResultType.BALL);
        }
        if (scores[1] > 0) {
            sb.append(scores[1]).append(ResultType.STRIKE);
        }

        return sb.toString();
    }

    public static int[] checkValue(List<Integer> target, String inputValue) {
        try{
            isValidInput(inputValue);
        } catch (InvalidInputException ie){
            System.out.println(ie.getMessage());
            throw new IllegalArgumentException();
        }

        int strikeCount = 0;
        String[] values = inputValue.split("");

        for (int i = 0; i < values.length; i++){
            if (Integer.parseInt(values[i]) == target.get(i)){
                values[i] = "0";
                strikeCount++;
            }
        }

        int ballCount = 0;

        for (String value : values){
            if (target.contains(Integer.parseInt(value))){
                ballCount++;
            }
        }

        return new int[] {ballCount, strikeCount};
    }

    public static void isValidInput(String inputValue) throws InvalidInputException{
        if (inputValue.isBlank() || inputValue.length() != 3) throw new InvalidInputException();

        Set<String> values = new HashSet<>(Arrays.asList(inputValue.split("")));

        if (values.size() != 3 || values.contains("0")) throw new InvalidInputException(); //중복 값 확인
    }

    public static boolean isRestart() {
        System.out.println(OUTPUTMESSAGE.END);
        System.out.println(OUTPUTMESSAGE.RESTART);

        String inputValue = Console.readLine();

        try{
            return restartValueHandle(inputValue);
        } catch (InvalidInputException ie){
            System.out.println(ie.getMessage());
            throw new IllegalStateException();
        }
    }

    public static boolean restartValueHandle(String inputValue) throws InvalidInputException{
        if (inputValue.equals(RESATRT_VALUE)) {
            return true;
        } else if (inputValue.equals(END_VALUE)) {
            return false;
        } else {
            throw new InvalidInputException();
        }
    }
}
