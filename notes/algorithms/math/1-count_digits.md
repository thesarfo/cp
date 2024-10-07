Lets say you are given an input number `554`, and you are to return the total number of individual integers in that number. How do you go about it.

First of all, we can initialize a `counter` variable and set it to `0`. But under what condition do we update this counter.  We will update this counter each time we extract a digit from the input number. To extract a digit from the input number, we can repeatedly divide the number by 10 and update our counter. Here's how we can do that:

We can do that by dividing our input number by 10. Let's take it this way, if your input number is `770`..

* Increment the counter by 1 because 770 is not zero.
* Divide 770 by 10, which gives us 77.
* Increment the counter again because 77 is not zero.
* Divide 77 by 10, which gives us 7.
* Increment the counter once more because 7 is not zero.
* Divide 7 by 10, which gives us 0.

Note that on each iteration where we divide our input number by 10, we update the result to the input number itself. `n = n / 10`

We continue this process until the result of dividing the input number by `10` is `0`. By the time we reach this point, our counter will have been updated to reflect the total number of individual digits in the input number.

Below is a sample implementation in java
```java
static int evenlyDivides(int N){
        int counter = 0;
        
        while (N > 0){
            counter +=1;
            N = N / 10;

        }
        return counter;
    }
```