/**
 * Group Anagrams. The idea is to sort the strings as we iterate through them, use the sorted string as a key in the map, and append all the strings
 * that have the same sorted string (an anagram) into the list corresponding to the sorted string key.
 *
 * Time Complexity: O(N*MlogM) M is the max length of an anagram (Time) | O(N*M) Space for the Map
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);

            List<String> currList = map.getOrDefault(sortedString, new ArrayList<>());
            currList.add(str);
            map.put(sortedString, currList);
        }

        for(String key: map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}