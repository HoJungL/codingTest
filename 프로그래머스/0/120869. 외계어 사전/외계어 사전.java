class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;

        for (int i = 0; i < dic.length; i++) {
            String str = dic[i];

            if (str.length() != spell.length) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < spell.length; j++) {
                String spe = spell[j];

                if (str.contains(spe)) {
                    count++;
                }
            }
            if (count == spell.length) {
                return 1;
            }
        }
        return 2;
    }
}