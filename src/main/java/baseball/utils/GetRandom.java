package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetRandom {
    private GetRandom(){}
    public static List<Integer> makeRandom(){
        List<Integer> target = new ArrayList<>(3);

        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }

        return target;
    }
}
