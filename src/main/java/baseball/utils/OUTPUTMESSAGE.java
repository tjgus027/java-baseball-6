package baseball.utils;

public enum OUTPUTMESSAGE {
    START{
        @Override
        public String toString() {
            return "숫자 야구 게임을 시작합니다.";
        }
    },
    INPUT{
        @Override
        public String toString() {
            return "숫자를 입력해 주세요 : ";
        }
    },
    END{
        @Override
        public String toString() {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
    },
    RESTART{
        @Override
        public String toString() {
            return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
    }
}
