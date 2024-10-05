class Solution
{
    int select(int arr[], int i)
    {
       
        int test[] = {1, 3, 4, 5, 6, 6, 21, 21, 3, 12, 3, 123, 12, 3, 1, 2, 3, 23, 12};
        selectionSort(test, test.length);
        return test[i];
    }
    
    void selectionSort(int arr[], int n)
    {
    
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; 
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j; 
                }
            }
            
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}

