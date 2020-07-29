class Solution {
    class Item {
        int median;
        int value;
        Item(int value, int median) {
            this.value = value;
            this.median = median;
        }
    }
    class IntComparator implements Comparator<Item>{ 
        public int compare(Item s1, Item s2) { 
            int dis1 = Math.abs(s1.value - s1.median);
            int dis2 = Math.abs(s2.value - s2.median);
            if (dis1 > dis2) {
                return -1;
            }
            
            if (dis1 == dis2) {
                if (s1.value > s2.value) return -1;
                else if (s1.value == s2.value) return 0;
                else return 1;
            }
            
            return 1;
        } 
    } 
    
    public int[] getStrongest(int[] arr, int k) {
        PriorityQueue<Item> heap = new PriorityQueue<>(new IntComparator());
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            array[i] = arr[i];
        }
        Arrays.sort(array);
        
        int median = array[(array.length - 1) / 2];
        //System.out.println(median);
        for (int i = 0; i < arr.length; ++i) {
            Item item = new Item(arr[i], median);
            // if (heap.size() == k) {
            //     heap.poll();
            // }
            heap.add(item);
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = heap.poll().value;
            //System.out.println(ans[i]);
        }
        
        return ans;
    }
}