class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        /*
            1. 增加元素
            2. 减去元素
            注意如果使用lambda expression, x - y 或者 y - x 可能会有integer overflow, 最好的办法是使用comparator
            a.getValue().compareTo(b.getValue())
        */
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        double[] array = new double[nums.length - k + 1];
        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            right.add(nums[i]);
            if (size % 2 == 0) {
                if (left.isEmpty()) {

                } else {
                    if (left.peek() > right.peek()) {
                        int leftnum = left.poll();
                        int rightnum = right.poll();
                        left.add(rightnum);
                        right.add(leftnum);
                    }
                }
            } else {
                left.add(right.poll());
            }
            size++;

            if (size == k) {
                if (size % 2 == 0) {
                    array[i - k + 1] = ((long)left.peek() + right.peek()) / 2.0;
                } else {
                    array[i - k + 1] = right.peek() / 1.0;
                }
                
                if (nums[i - k + 1] >= right.peek()) {
                    right.remove(nums[i - k + 1]);
                }
                else {
                    left.remove(nums[i - k + 1]);
                }
                
                if (left.size() > right.size()) {
                    right.add(left.poll());
                } else if (right.size() > left.size() + 1) {
                    left.add(right.poll());
                }
                size--;
            }
        }
        return array;
    }
}