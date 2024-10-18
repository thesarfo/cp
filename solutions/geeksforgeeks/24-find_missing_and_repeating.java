class Solve {
    int[] findTwoElement(int arr[]) {
        bubbleSort(arr);
        int n = arr.length;
        int sum = 0;
        int[] res = new int[2];
        
        for (int i = 0; i < n - 1; i++) {  
            if (arr[i] == arr[i + 1]) {
                res[0] = arr[i]; 
            }
            sum += arr[i];
        }
        sum += arr[n - 1]; 

        int actualSum = n * (n + 1) / 2;
        
        res[1] = actualSum - (sum - res[0]); 
        return res;
    }

    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}