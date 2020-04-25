class Solution {
    public boolean isStrobogrammatic(String num) {
        /*
            String and Character
        */
        char[] array = num.toCharArray();
        int length = array.length;
        for (int i = 0; i < length / 2 + 1; ++i) {
            if (array[i] - '0' == 0 && array[length - 1 - i] == array[i]) {
                continue;
            } else if (array[i] - '0' == 1 && array[length - 1 - i] == array[i]) {
                continue;
            } else if (array[i] - '0' == 6 && array[length - 1 - i] - '0' == 9) {
                continue;
            } else if (array[i] - '0' == 8 && array[length - 1 - i] == array[i]) {
                continue;
            } else if (array[i] - '0' == 9 && array[length - 1 - i] - '0' == 6) {
                continue;
            } else return false;
        }
        return true;
    }
}