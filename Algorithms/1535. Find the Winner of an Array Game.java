class Solution {
    /*
        Simulation using Linked List
    */
    // class Node {
    //     int val;
    //     Node next;
    //     public Node(int val) {
    //         this.val = val;
    //     }
    // }
    
//     public int getWinner(int[] arr, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         Node head = new Node(-1);
//         Node current = head;
//         for (int i : arr) {
//             Node node = new Node(i);
//             current.next = node;
//             current = node;
//             map.put(i, 0);
//         }
//         Node last = current;

//         current = head.next;
//         while(true) {
//             Node second = current.next;
//             if (current.val > second.val) {
//                 map.put(current.val, map.get(current.val) + 1);
//                 map.put(second.val, 0);
//                 //System.out.println(current.val + " " + map.get(current.val));
//                 if (map.get(current.val) >= k || map.get(current.val) >= arr.length - 1) return current.val;
                
//                 Node node = new Node(second.val);
//                 last.next = node;
//                 last = node;
//                 current.next = current.next.next;
//             } else {
//                 map.put(second.val, map.get(second.val) + 1);
//                 map.put(current.val, 0);
//                 //System.out.println(second.val + " " + map.get(second.val));

//                 if (map.get(second.val) >= k || map.get(second.val) >= arr.length - 1) return second.val;
                
//                 Node node = new Node(current.val);
//                 last.next = node;
//                 last = node;
//                 current = current.next;
//             }
//         }
//     }
    
    /*
        Single scan without shifting
            Note: the larger number will always be left at the begining of the array
            if we finished scaning the whole array, and still no number wins k round in a row, we return the largest number
            if we have found the winner before finishing the array, break loop and return the answer
    */
    public int getWinner(int[] arr, int k) {
        int count = 0;
        int ans = arr[0];
        
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > ans) {
                count = 1;
                ans = arr[i];
            } else {
                count++;
            }
            
            if (count == k) {
                break;
            }
        }
        
        return ans;
    }
}