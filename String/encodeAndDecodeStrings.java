public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while(i < s.length()) {
            int hash = s.indexOf('#', i);
            int size = Integer.valueOf(s.substring(i, hash));
            i = hash + size + 1;
            result.add(s.substring(hash + 1, i));
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));