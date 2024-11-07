class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int flag = 0;

        for (int i = 0; i < places.length; i++) {
            flag = 0;
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[j].length; k++) {
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
                        if (flag == 1) {
                            break;
                        }
                        for (int l = 1; l <= 2; l++) {
                            if (k - l >= 0 && places[i][j].charAt(k - l) == 'P') {
                                flag = 1;
                                break;
                            } else if (k -l >= 0 && places[i][j].charAt(k - l) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                        // 세로
                        for (int l = 1; l <= 2; l++) {
                            if (j + l < 5 && places[i][j + l].charAt(k) == 'P') {
                                flag = 1;
                                break;
                            } else if (j + l < 5 && places[i][j + l].charAt(k) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                        for (int l = 1; l <= 2; l++) {
                            if (j - l >= 0 && places[i][j - l].charAt(k) == 'P') {
                                flag = 1;
                                break;
                            } else if (j - l >= 0 && places[i][j - l].charAt(k) == 'X') {
                                break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                        // 대각선1
                        for (int l = 1; l <= 1; l++) {
                            if (j + l < 5 && k + l < 5 && places[i][j + l].charAt(k + l) == 'P'
                                    &&!(places[i][j + l].charAt(k)=='X'&&places[i][j].charAt(k+l)=='X')) {
                                    flag = 1;
                                    break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                        // 대각선2
                        for (int l = 1; l <= 1; l++) {
                            if (j - l >=0 && k - l >=0 && places[i][j - l].charAt(k - l) == 'P'
                                    &&!(places[i][j - l].charAt(k)=='X'&&places[i][j].charAt(k-l)=='X')) {
                                    flag = 1;
                                    break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                        // 대각선3
                        for (int l = 1; l <= 1; l++) {
                            if (j + l < 5 && k - l >= 0 && places[i][j + l].charAt(k - l) == 'P'
                                    &&!(places[i][j + l].charAt(k)=='X'&&places[i][j].charAt(k-l)=='X')) {
                                    flag = 1;
                                    break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                        // 대각선4
                        for (int l = 1; l <= 1; l++) {
                            if (j - l >= 0 && k + l < 5 && places[i][j - l].charAt(k + l) == 'P'
                                    &&!(places[i][j - l].charAt(k)=='X'&&places[i][j].charAt(k+l)=='X')) {
                                    flag = 1;
                                    break;
                            }
                        }
                        if (flag == 1) {
                            break;
                        }
                    }
                    if (flag == 1) {
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }    
            }
            if (flag != 1) {
                answer[i] = 1;
            }
        }
        return answer;
    }
}