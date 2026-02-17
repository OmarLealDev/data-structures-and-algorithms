package algorithms.sorting;

public class Sorting {


    public void bubble(int[] list) {
        for(int i = 0; i < list.length - 1; i++){
            
            boolean swapped = false;
            
            for(int j = 0; j < list.length - 1 - i; j++){

                if(list[j] > list[j + 1]){
                    
                    int temp = list[j];
                    
                    list[j] = list[j + 1];
                    
                    list[j + 1] = temp;
                    
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

        }
        
    }

    public void selection(int[] list) {
        // Selection sort implementation
        for(int i = 0; i < list.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j] < list[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }
}
