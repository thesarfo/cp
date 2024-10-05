vector<int> rotateArray(vector<int>arr, int k) {
    // Write your code here.
    k = k % arr.size(); // just rotate by the surplus

    int temp[k];

    for(int i = 0; i < k; i++){
        temp[i] = arr[i];
    }

    for(int i = k; i < arr.size(); i++){
        arr[i - k] = arr[i];
    }

    for(int i = arr.size() - k; i < arr.size(); i++){
        arr[i] = temp[i - (arr.size() - k)];
    }
    return arr;
}