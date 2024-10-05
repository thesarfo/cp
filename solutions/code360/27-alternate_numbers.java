## Another Variation - Positive and Negative Values are not of equal length


What if the number of positive and negative elements are not the same, and we should add any surplus to the end of the array without thinking of order.

There are two scenarios to this, either positive values are more than negative values or negative values are more than positive values.

Take this array `[-1, 2, 3, 4, -3, 1]` for example, the final answer will be []

We can use the above brute solution for this, we will just create two positive and negative arrays and store values in them. At the end of othis operation, we will know if the number of positives are more than the number of negatives. Based on that, we have a clear idea of which parts of our final array(or how many elements in our final array) will be in order, and which ones will not. For instance, if the number of negatives are `2`, we know that the first `4` elements in our final array will be in alternating order.

(use the above array as an example to explain this)

Below is a java implementation 
```java
public class Solution {
    public static int[] alternateNumbers(int[] a) {
        int[] pos = new int[a.length];
        int[] neg = new int[a.length];
        
        int posIndex = 0, negIndex = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                pos[posIndex++] = a[i];
            } else {
                neg[negIndex++] = a[i];
            }
        }

        int index = 0;
        int minLength = Math.min(posIndex, negIndex);

        for (int i = 0; i < minLength; i++) {
            a[index++] = pos[i];
            a[index++] = neg[i];
        }

        for (int i = minLength; i < posIndex; i++) {
            a[index++] = pos[i];
        }

        for (int i = minLength; i < negIndex; i++) {
            a[index++] = neg[i];
        }

        return a;
    }
}
```

```java
for(i = 0; i < (lesser_array_value); i++){
    arr[i * 2] = pos[i];
    arr[i * 2 + 1] = neg[i];
}

// add the surplus to the final array
index = num-of-sorted-elements-in-final-array;

for(i = (greater_array_end); i < (greater_array.size); i++){
    arr[index] = pos[i];
    index++;
}
```