/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    /*
        Brute force
    */
//     List<Employee> lists;
//     int total = 0;
//     public int getImportance(List<Employee> employees, int id) {
//         lists = employees;
//         for (Employee employee : lists) {
//             if (employee.id == id) {
//                 total += employee.importance;
//                 helper(employee.subordinates);
//             }
//         }
//         return total;
//     }
    
//     private void helper(List<Integer> list) {
//         for (Employee employee : lists) {
//             if (list.contains(employee.id)) {
//                 total += employee.importance;
//                 helper(employee.subordinates);
//             }
//         }
//     }
    
    /*
        DFS 
        HashMap
    */
    Map<Integer, Employee> map;
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        helper(id);
        return total;
    }
    
    private void helper(int id) {
        Employee employee = map.get(id);
        total += employee.importance;
        for (int i : employee.subordinates) {
            helper(i);
        }
    }
}