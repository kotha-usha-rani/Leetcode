class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        if(s.compareTo(t) == 0)
            return true;
        //Method 1 convert to charArray, check if their characters are equal
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);
        // for(int i=0 ; i<sArr.length ; i++){
        //     if(sArr[i] != tArr[i])
        //         return false;
        // }
        // return true;
        
        //store the count of characters of one string in a hashmap, check if all the 
        //characters of another string are present
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        for(int i=0 ; i<t.length() ; i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch) && map.get(ch) > 0)
                map.put(ch, map.get(ch)-1);
            else
                return false;
        }
        return true;
        
    }
}