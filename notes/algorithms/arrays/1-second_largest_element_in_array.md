
This is how we can brute force this problem. We can first sort the array, and then the second largest will simply be the second to last element in the array. But this logic would not work if our array contains duplicate elements. So we need to find a better way.


## Better Approach

First, we find the largest element in the array. And then we initialize a variable to hold the second largest element in the array = -1, at first. Then we loop through the array, if the current array element is greater than the variable holding the second largest element, and the current array element is not the largest, that is our second largest.

#### Implementation of Better Approach

```java
// find the largest
int getSecondLargest(arr, n){
	int largest = arr[0];
	for(int i = 0; i < n; i++){
		if(arr[i] > largest){
			largest = arr[i];
		}
	}

	int slargest = -1;
	for(int i = 0; i < n; i++){
		if(arr[i] > slargest && arr[i] != largest){
			slargest = arr[i];
		}
	}
	return slargest;
}
```


## Optimal Approach

We can define our largest variable to `arr[0]` and second largest to `-1`.  Then we loop through the array from the second element(since the first is our largest). Now, we check if the second element is greater than the largest(first). If it is, we assign the largest variable to the second element, and the first element(previous largest) is assigned to our second largest variable.

### Implementation of Optimal Approach

We will assume to return both the largest and second largest in this approach - but should work the same way.

```cpp
int secondLargest(vector<int> &a, int n){
    int largest = a[0];
    int slargest = -1;

    for (int i = 1; i < n; i++){
        if(a[i] > largest){
            slargest = largest;
            largest = a[i];
        }
        else if(a[i] < largest && a[i] > slargest){
            slargest = a[i];
        }
    }
    return slargest;
}

int secondSmallest(vector<int> &a, int n){
    int smallest = a[0];
    int ssmallest = INT_MAX;

    for(int i = 1; i < n; i++){
        if(a[i] < smallest){
            ssmallest = smallest;
            smallest = a[i];
        }
        else if(a[i] != smallest && a[i] < ssmallest){
            ssmallest = a[i];
        }
    }
    return ssmallest;
}

vector<int> getSecondOrderElements(int n, vector<int> a) {
    // Write your code here.
    int slargest = secondLargest(a, n);
    int ssmallest = secondSmallest(a, n);

    return {slargest, ssmallest};
}
```

```cpp fold title:test.cpp
int main(){
	printf("hello world");
}
```