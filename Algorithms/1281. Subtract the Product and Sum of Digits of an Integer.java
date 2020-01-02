class Solution {
    /*
        Math
    */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        
        String str = Integer.toString(n);
        
        for (char c : str.toCharArray()) {
            product *= c - '0';
            sum += c - '0';
        }
        System.out.println(product);
        System.out.println(sum);
        return product - sum;
    }
}