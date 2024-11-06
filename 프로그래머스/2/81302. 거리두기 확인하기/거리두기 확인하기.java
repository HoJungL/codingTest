class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int flag;

        for (int i = 0; i < places.length; i++) {
            flag = 0;
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        // 가로
                        for (int l = 1; l <= 2; l++) {
                            if (k + l < 5 && places[i][j].charAt(k + l) == 'P') {
                                flag = 1;
                                break;
                            } else if (k + l < 5 && places[i][j].charAt(k + l) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) break;
                        for (int l = 1; l <= 2; l++) {
                            if (k - l >= 0 && places[i][j].charAt(k - l) == 'P') {
                                flag = 1;
                                break;
                            } else if (k - l >= 0 && places[i][j].charAt(k - l) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) break;
                        // 세로
                        for (int l = 1; l <= 2; l++) {
                            if (j + l < 5 && places[i][j + l].charAt(k) == 'P') {
                                flag = 1;
                                break;
                            } else if (j + l < 5 && places[i][j + l].charAt(k) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) break;
                        for (int l = 1; l <= 2; l++) {
                            if (j - l >= 0 && places[i][j - l].charAt(k) == 'P') {
                                flag = 1;
                                break;
                            } else if (j - l >= 0 && places[i][j - l].charAt(k) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) break;
                        // 대각선1
                        if (j + 1 < 5 && k + 1 < 5 && places[i][j + 1].charAt(k + 1) == 'P'
                                && !(places[i][j + 1].charAt(k) == 'X' && places[i][j].charAt(k + 1) == 'X')) {
                            flag = 1;
                            break;
                        }
                        // 대각선2
                        if (j - 1 >= 0 && k - 1 >= 0 && places[i][j - 1].charAt(k - 1) == 'P'
                                && !(places[i][j - 1].charAt(k) == 'X' && places[i][j].charAt(k - 1) == 'X')) {
                            flag = 1;
                            break;
                        }
                        // 대각선3
                        if (j + 1 < 5 && k - 1 >= 0 && places[i][j + 1].charAt(k - 1) == 'P'
                                && !(places[i][j + 1].charAt(k) == 'X' && places[i][j].charAt(k - 1) == 'X')) {
                            flag = 1;
                            break;
                        }
                        // 대각선4
                        if (j - 1 >= 0 && k + 1 < 5 && places[i][j - 1].charAt(k + 1) == 'P'
                                && !(places[i][j - 1].charAt(k) == 'X' && places[i][j].charAt(k + 1) == 'X')) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) break;
                }
                if (flag == 1) break;
            }
            answer[i] = (flag == 1) ? 0 : 1;
        }
        return answer;
    }
}
