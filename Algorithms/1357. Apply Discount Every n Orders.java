class Cashier {
    int index;
    int discount;
    int n;
    Map<Integer, Integer> map;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        index = 0;
        map = new HashMap<>();
        for (int i = 0; i < products.length; ++i) {
            map.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        double total = 0;
        int length = product.length;
        for (int i = 0; i < length; ++i) {
            total += map.get(product[i]) * amount[i];
        }
        
        index++;
        if (index == n) {
            total = total - (discount * total) / 100;
            index = 0;
        }
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */