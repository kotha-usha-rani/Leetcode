/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int count = 0;
        while(!queue.isEmpty()){
            int currId = queue.remove();
            for(int i=0 ; i<employees.size() ; i++){
                if(employees.get(i).id == currId){
                    count += employees.get(i).importance;
                    for(int j=0 ; j<employees.get(i).subordinates.size() ; j++){
                        queue.add(employees.get(i).subordinates.get(j));
                    }
                    break;
                }
            }
        }
        return count;
    }
}














