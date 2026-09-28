class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] words = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        for (int i =0 ; i<10; i++){
            numbers = numbers.replace(words[i],Integer.toString(i));
        }
        answer = Long.parseLong(numbers);
        return answer;
    }
}