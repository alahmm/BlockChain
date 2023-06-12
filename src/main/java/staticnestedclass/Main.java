package staticnestedclass;

public class Main {
}
class StringOperations {

    public static class EngString {
        private boolean english;
        private String string;

        public EngString(boolean english, String string) {
            this.english = english;
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public boolean isEnglish() {
            return english;
        }
    }

}