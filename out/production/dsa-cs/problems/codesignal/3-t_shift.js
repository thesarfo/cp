function solution(nums) {
    const n = nums.length;
    
    const isSorted = arr => {
        for (let i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    };
    
    for (let t = 0; t < n; t++) {
        const shiftedArray = [...nums.slice(t), ...nums.slice(0, t)];
        if (isSorted(shiftedArray)) {
            return t;
        }
    }
    
    return -1;
}