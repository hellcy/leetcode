class Solution {
    public int countCharacters(String[] words, String chars) {
        /*
            Algorithm explained:
                put chars into a 26 size array, each index represent the time of appearance for each English character
                in the for loop, do the same thing for each string in the array as well,
                if any number in the array is greater than the number in the check array, than we know we can't form that word
                otherwise a
        */
        int[] check = new int[26];
        char[] cs = chars.toCharArray();
        for (char c : cs) {
            check[c - 'a']++;
        }
        
        int count = 0;
        for (String s : words) {
            int[] array = new int[26];
            char[] current = s.toCharArray();
            for (char c : current) {
                array[c - 'a']++;
            }
            Boolean flag = true;
            for (int i = 0; i < 26; ++i) {
                if (array[i] > check[i]) flag = false;
            }
            if (flag) count += s.length();
        }
        
        return count;
        /*
            Algorithm explained:
                create a list contains all characters from chars
                for each string, we check each character to see if it is included in chars
                add the length to count if all found
        */
        // List<Character> list = new ArrayList<>();
        // char[] c = chars.toCharArray();
        // for (int i = 0; i < c.length; ++i) {
        //     list.add(c[i]);
        // }
        // List<Character> temp = new ArrayList<>();
        // temp.addAll(list);
        // int count = 0;
        // boolean flag = true;
        // for (int i = 0; i < words.length; ++i) {
        //     char[] word = words[i].toCharArray();
        //     flag = true;
        //     for (int j = 0; j < word.length; ++j) {
        //         if (temp.contains(word[j])) {
        //             temp.remove(new Character(word[j]));
        //         } else {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if (flag) count += words[i].length();
        //     temp.clear();
        //     temp.addAll(list);
        // }
        // return count;
    }
}