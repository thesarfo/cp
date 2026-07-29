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
        if (k >= prefix.size()) {
            return 0;
        }

        int n = prefix.size();
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}
