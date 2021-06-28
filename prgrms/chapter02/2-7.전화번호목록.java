import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> hs = new HashSet<>();

        for (String phone : phoneBook) {
            hs.add(phone);
        }

        for (String phone : phoneBook) {
            for (int i = 0; i < phone.length(); i++) {
                if (hs.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}