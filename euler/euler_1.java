class HelloWorld {
    public static void main(String[] args) {
        nums(1000);
    }
    
    public static void nums(int n){
        int sum = 0;
        for (int i = 1; i < n; i++){
            if (i % 3 == 0 || i % 5 == 0){
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}