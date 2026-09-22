class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            if (mode == 0) {
                char cha = code.charAt(i);
                if (cha == '1') {
                    mode = 1;
                } else {
                    if (i % 2 == 0) {
                        answer.append(cha);
                    }
                }
            } else if (mode == 1) {
                char cha = code.charAt(i);
                if (cha == '1') {
                    mode = 0;
                } else {
                    if (i % 2 == 1) {
                        answer.append(cha);
                    }
                }
            }

        }
                    if (answer.isEmpty()) {
                return "EMPTY";
            }
        return answer.toString();
    }
}