class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0 ; i<strs.length ; i++){
            char[] arr = new char[26];
            for(int j=0 ; j<strs[i].length() ; j++)
                arr[strs[i].charAt(j)-'a']++;
            String key = String.valueOf(arr);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}