class ParkingSystem {
    int[] array;
    int[] limit;
    public ParkingSystem(int big, int medium, int small) {
        array = new int[3];
        limit = new int[] {big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (array[carType - 1] == limit[carType - 1]) return false;
        array[carType - 1]++;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */