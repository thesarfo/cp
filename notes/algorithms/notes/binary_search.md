**Binary search** requires a sorted data-set. We then take the following steps:

* Check the middle value of the dataset.
* If this value matches our target we can return the index.
* If the middle value is less than our target
* Start at step 1 using the right half of the list.
* If the middle value is greater than our target
* Start at step 1 using the left half of the list.
* We eventually run out of values in the list or find the target value.