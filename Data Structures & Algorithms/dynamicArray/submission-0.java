class DynamicArray {
    private int[] array;
    private int size; // number of elements in array
    public DynamicArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        if (i < 0 || i > this.array.length - 1) return -1;
        return array[i];
    }

    public void set(int i, int n) {
        // just updating existing element
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (this.size == this.array.length) {
            this.resize();
        }
        // push element n to end of array
        this.array[this.size] = n;
        this.size++;
    }

    public int popback() {
        int retVal = this.array[this.size - 1];
        this.array[this.size - 1] = 0;
        this.size--;
        return retVal;
    }

    private void resize() {
        int[] temp = this.array;
        this.array = new int[temp.length * 2];
        for (int i = 0; i < temp.length; ++i) {
            this.array[i] = temp[i];
        }
        temp = null;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.array.length;
    }
}
