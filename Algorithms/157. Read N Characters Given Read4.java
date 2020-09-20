/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        int current = n;
        while (current >= 0) {
            current -= 4;
            char[] temp = new char[4];
            int size = read4(temp);
            
            for (int i = index; i < index + size; ++i) {
                buf[i] = temp[i - index];
            }
            index += size;
        }
        return index < n ? index : n;
    }
}