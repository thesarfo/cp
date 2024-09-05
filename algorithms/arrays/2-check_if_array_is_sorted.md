
This is a pretty simple solution. We traverse the array from the first index. Then we check with the previous index. If the current index is greater or equal to the previous index, we go to the next. We do these checking all the way until we reach the end of our array.

A simple pseudocode would look like this.

```pseudocode
for(int i = 1; i < n; i++){
	if(arr[i] >= arr[i-1]){
	
	}else{
		return false;
	}
}
return true;
```






































