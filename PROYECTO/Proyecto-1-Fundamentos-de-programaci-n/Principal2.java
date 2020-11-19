import java.util.Arrays;

public class Principal2 {

    public static void main(String[] args) {

    int[] nums = {9,5,3,8,5,3,56};

  
  
    for(int grande = 0; grande < nums.length;grande++){
        for(int peque = grande + 1; peque < nums.length; peque++){

            if(nums[grande] > nums[peque]){
                int porelmomento = nums[grande];
                nums[grande] = nums[peque];
                nums[peque] = porelmomento;
            }
        }
     
    }



        
    }
    
}
