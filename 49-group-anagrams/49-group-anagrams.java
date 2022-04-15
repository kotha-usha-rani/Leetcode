class Solution {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        int[] arr = new int[256];
        for(int i=0 ; i<s.length() ; i++){
            arr[s.charAt(i)-'0']++;
        }
        for(int i=0 ; i<t.length() ; i++){
            arr[t.charAt(i)-'0']--;
            if(arr[t.charAt(i)-'0'] < 0)
                return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : strs){
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else
                map.put(s, 1);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0 ; i<strs.length ; i++){
            if(map.containsKey(strs[i])){
                List<String> list = new ArrayList<>();
                int n = map.get(strs[i]);
                while(n > 0){
                    list.add(strs[i]); n--;
                }
                map.remove(strs[i]);
                for(int j=i+1 ; j<strs.length ; j++){
                    if(map.containsKey(strs[j]) && isAnagram(strs[i], strs[j])){
                        n = map.get(strs[j]);
                        while(n > 0){
                            list.add(strs[j]); n--;
                        }
                        map.remove(strs[j]);
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }
}