/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int helper(List<Employee> employees, int id, HashMap<Integer, Employee> map){
        Employee temp = map.get(id);
        int count = temp.importance;
        for(int subId : temp.subordinates)
            count += helper(employees, subId, map);
        return count;
    }
    public int getImportance(List<Employee> employees, int id) {
        //recursive
        // for(int i=0 ; i<employees.size() ; i++){
        //     if(employees.get(i).id == id){
        //         int count = employees.get(i).importance;
        //         for(int j=0 ; j<employees.get(i).subordinates.size() ; j++){
        //             count += getImportance(employees, employees.get(i).subordinates.get(j));
        //         }
        //         return count;
        //     }
        // }
        // return 0;
        
        
        //iterative
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(id);
        // int count = 0;
        // while(!queue.isEmpty()){
        //     int currId = queue.poll();
        //     Employee temp = map.get(currId);
        //     count += temp.importance;
        //     for(int subId : temp.subordinates)
        //         queue.add(subId);
        // }
        // return count;
        
        return helper(employees, id, map);
    }
}














