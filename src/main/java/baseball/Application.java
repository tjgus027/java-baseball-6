package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");
        application.running();

    }

    private List<Integer> makeRandom(){
        List<Integer> target = new ArrayList<>(3);

        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }
        
        return target;
    }

    private void running() throws IllegalArgumentException {
        List<Integer> target = makeRandom();

        while (true){
            System.out.print("숫자를 입력해 주세요 : ");
            String inputValue = Console.readLine();

            String result = getResult(target, inputValue);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                choiceRestart();
                break;
            }
        }


    }

    private int[] checkValue(List<Integer> target, String inputValue) throws IllegalArgumentException{
        isValidInput(inputValue);

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

    private String getResult(List<Integer> target, String inputValue) throws IllegalArgumentException{
        int[] scores = checkValue(target, inputValue);
        StringBuilder sb = new StringBuilder();

        if (scores[0] == 0 && scores[1] == 0) return "낫싱";

        if (scores[0] > 0){
            sb.append(scores[0]).append("볼 ");
        }
        if (scores[1] > 0) {
            sb.append(scores[1]).append("스트라이크");
        }

        return sb.toString();
    }

    public void isValidInput(String inputValue) throws IllegalArgumentException{
        if (inputValue.isBlank() || inputValue.isEmpty()) throw new IllegalArgumentException(); //빈값 체크
        if (inputValue.length() != 3) throw new IllegalArgumentException(); //3자리 확인

        Set<String> values = new HashSet<>(Arrays.asList(inputValue.split("")));
        if (values.size() != 3) throw new IllegalArgumentException(); //중복 값 확인
        if(values.contains("0")) throw new IllegalArgumentException(); //0이 있는지 확인
    }

    private void choiceRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = Console.readLine();

        if (inputValue.equals("1")) {
            running();
        } else if (inputValue.equals("2")) {
            Console.close();
        } else {
            throw new IllegalStateException();
        }

    }

}
