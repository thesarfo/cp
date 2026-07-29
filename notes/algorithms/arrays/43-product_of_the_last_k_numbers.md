We are given a stream of integers and need to retrieve the product of the last `k` numbers added. Implement `ProductOfNumbers` with `add(num)` and `getProduct(k)`.

[Leetcode Problem](https://leetcode.com/problems/product-of-the-last-k-numbers/description/)

### 1. Brute Force Solution:
#### Idea:
- Store all numbers in a list. On `getProduct(k)`, iterate over the last `k` elements and multiply them.

#### Code:
```java
class ProductOfNumbers {
    private List<Integer> values;

    public ProductOfNumbers() {
        values = new ArrayList<>();
    }

    public void add(int num) {
        values.add(num);
    }

    public int getProduct(int k) {
        int product = 1;
        for (int i = values.size() - k; i < values.size(); i++) {
            product *= values.get(i);
        }
        return product;
    }
}
```

#### Time Complexity:
- **add:** O(1)
- **getProduct:** O(k)

#### Space Complexity:
- **O(n):** Stores all numbers.

### 2. Optimal Solution (Prefix Product):
#### Idea:
- Maintain a cumulative product list (prefix). `prefix[i]` = product of all elements from the start up to the `i`-th element.
- Problem: zeros reset everything — any product spanning a zero is zero.
- Fix: When `num == 0`, reset the prefix list to `[1]`. On `getProduct(k)`, if `k >= prefix.size()`, a zero was in range so return 0. Otherwise, return `prefix.last() / prefix[prefix.size() - 1 - k]`.

#### Steps:
1. Initialize `prefix = [1]`.
2. **add(num):**
   - If `num == 0`, reset `prefix` to `[1]`.
   - Else, append `prefix.last() * num` to `prefix`.
3. **getProduct(k):**
   - If `k >= prefix.size()`, return 0.
   - Else return `prefix.last() / prefix[prefix.size() - 1 - k]`.

#### Code:
```java
class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k >= prefix.size()) return 0;
        return prefix.get(prefix.size() - 1) / prefix.get(prefix.size() - 1 - k);
    }
}
```

#### Time Complexity:
- **add:** O(1)
- **getProduct:** O(1)

#### Space Complexity:
- **O(n):** For the prefix list.

### Summary:
1. **Brute Force:** Simple but O(k) per query.
2. **Prefix Product:** O(1) per query by leveraging cumulative products. Handles zeros with a reset.

### Key Concepts:
1. **Prefix products** give O(1) range product queries.
2. **Zero handling:** Reset the prefix on zero since any product crossing it is zero.
