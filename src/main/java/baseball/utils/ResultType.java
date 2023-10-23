package baseball.utils;

public enum ResultType {
    STRIKE {
        @Override
        public String toString() {
            return "스트라이크";
        }
    },
    BALL{
        @Override
        public String toString() {
            return "볼";
        }
    },
    NOTHING{
        @Override
        public String toString() {
            return "낫싱";
        }
    },
    TARGET{
        @Override
        public String toString() {
            return "3스트라이크";
        }
    }

}
