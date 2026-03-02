package Day1;
import java.util.*;

public class ContainsDuplicates {
    
    public boolean containsDuplicate(int[] nums) {
       Set<Integer> st = new HashSet<>();
       for(int i:nums){
        if(st.contains(i)) return true;
        st.add(i);
       } 
       return false;
    }
}

