class ProductOfNumbers {

    ArrayList<Integer> lst;
    int size;
    public ProductOfNumbers() {
        lst = new ArrayList<>();
        size = 0;
    }
    
    public void add(int num) {
        lst.add(num);
        size++;
    }
    
    public int getProduct(int k) {
        int product = 1;
        for(int i = size-1; i >= size-k; i--){
            product *= lst.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */