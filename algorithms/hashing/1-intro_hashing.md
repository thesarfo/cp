Let's take this example, supposed you have been given an array `[1, 2, 1, 3, 2]`. And you have to find the number of times a particular number appears in that array. For instance `1`.

Obviously, we can perform a linear solution where we will iterate through the array and increase a counter whenever we meet `1`.
```java
int function(n, arr){
    int count = 0;
    for (int i = 0; i < arr.length; i++){
        if (arr[i] == n){
            count = count + 1;
        }
    }
    return count;
}
```

This solution works...but there is a slight challenge. What if the length of the array is too long, say `10**5`, and the we have to find the occurrence of say numbers `10*5`. This will take a very long time for our above solution to work.

This is where **Hashing** comes in, in layman terms, hashing can be explained as **"pre-storing and fetching"**. Now let's say we have an array `[1, 3, 1, 5, 6, 7, 8, 6]`, and our problem statement says that at max, our array will contain numbers up till 12. What hashing say's is that "oh, now i know i can have numbers from 1 to 12", so what I can do is that, I can create another array, lets say `hashArray`, and this array will contain 13 indexes i.e `0 through to 12`. Initially, all the indexes of hashArray will be assigned to `0`. Now we start checking through our original array - `[1, 3, 1, 5, 6, 7, 8, 6]`, starting from `1`, we go to the index `1` of our hashArray and tell it to remember that we have one `1` in the original array. Therefore, the `hashArray[1] = 1`. Then we go to the second number in our original array -> `3`. Now we will go to the 3rd index in our hashArray and tell it to remember that we have just one 3 at this point. Therefore `hashArray[3] = 1`. 

For our third number in the original array which is `1`, we will still to to the 1st index in our hashArray and tell it to increment its value by one, since the number 1 has re-appeared. Therefore `hashArray[1] = 2`. We do this till we get to the end of the original array, now if we observe carefully, we will note that the indexes in our hashArray will actually contain the number of occurrences that their corresponding numbers appear in the original array.

What we have done above is the **pre-storing**. So now if we were to actually count the number of occurrences of lets say `1`, all we have to do is to return the value of `hashArray[1]` -> since it contains the value. Similarly, if we were given the number `5`, we just have to return the value of `hashArray[5]`. Instead of looping in the original array, we get our answer directly, by querying the hashArray. This is the **fetching** part.

Lets take the below **example**.
We are given an int array with a potential maximum value of `12`. Let's say `arr = [1, 3, 2, 1, 3]`. Now we are to count the number of times the following numbers appear in the array. The numbers in question are `(1, 4, 2, 3, 12)`

Below is a simple java implementation

```java
import java.util.Scanner;

public class HashingExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the array
        int n = sc.nextInt();
        int[] origArr = new int[n];

        // Input elements of the array
        for (int i = 0; i < n; i++) {
            origArr[i] = sc.nextInt();
        }

        // Precompute the frequency of each element
        int[] hashArr = new int[13]; // assuming maximum value is 12
        for (int i = 0; i < n; i++) {
            hashArr[origArr[i]] += 1;
        }

        // Input number of queries
        int q = sc.nextInt();
        while (q-- > 0) {
            int number = sc.nextInt();
            // Fetch the frequency of the number
            System.out.println(hashArr[number]);
        }

        sc.close();
    }
}
```

Though, you should note that the value of integer hash arrays have a max of 10e6 in the main method, and 10e7 globally