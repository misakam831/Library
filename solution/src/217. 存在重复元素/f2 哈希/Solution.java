import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for (int i :nums){
            set.add(i);
        }
        if (set.size()==nums.length){
            return false;
        }
        else {
            return true;
        }
    }
}