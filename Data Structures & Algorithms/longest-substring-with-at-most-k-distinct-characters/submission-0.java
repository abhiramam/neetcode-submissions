class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.containsKey(s.charAt(left)) && map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1);
            right++;

        }
        return maxLength;
    }
}
