package baseball;

import baseball.utils.ResultType;
import camp.nextstep.edu.missionutils.Console;
import baseball.controller.InputController;
import baseball.exception.InvalidInputException;
import baseball.utils.GetRandom;
import baseball.utils.OUTPUTMESSAGE;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application baseballGame = new Application();
        System.out.println(OUTPUTMESSAGE.START);
        baseballGame.running();
    }

    public void running() {
        List<Integer> target = GetRandom.makeRandom();

        while (true) {
            System.out.print(OUTPUTMESSAGE.INPUT);
            String inputValue = Console.readLine();

            String result = InputController.getResult(target, inputValue);
            System.out.println(result);

            if (result.equals(ResultType.TARGET.toString())) {
                askRestart();
                break;
            }
        }
    }

    public void askRestart(){
        boolean isRestart = InputController.isRestart();
        if (isRestart){
            running();
        } else{
            Console.close();
        }
    }

}
