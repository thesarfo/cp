class Solution
{
  static void insert(int arr[],int i)
  {
       // Your code here
       int[] numbers = {1, 2, 3, 4, 5};
       i = 5;
       
  }
  //Function to sort the array using insertion sort algorithm.
  public void insertionSort(int arr[], int n)
  {
      //code here
      for (int i = 1; i < n; i++){
            int j = i;
            
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                
                j--;
            }
        }
  }
}