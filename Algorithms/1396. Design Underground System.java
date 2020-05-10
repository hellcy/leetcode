class UndergroundSystem {
    /*
        HashMap
        Pair
    */
    Map<Pair<Integer, String>, Integer> map1;
    Map<Integer, String> ids;
    Map<Pair<String, String>, List<Integer>> station;
    public UndergroundSystem() {
        map1 = new HashMap<>();
        station = new HashMap<>();
        ids = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair<Integer, String> pair = new Pair<>(id, stationName);
        map1.put(pair, t);
        ids.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String instation = ids.get(id);
        Pair<Integer, String> pair = new Pair<>(id, instation);
        int intime = map1.get(pair);
        map1.remove(new Pair<>(id, instation));
        
        Pair<String, String> route = new Pair<>(instation, stationName);
        
        if (station.containsKey(route)) {
            station.get(route).add(t - intime);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(t - intime);
            station.put(route, list);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> list = station.get(new Pair<>(startStation, endStation));
        int size = list.size();
        int totaltime = 0;
        for (int i : list) {
            totaltime += i;
        }
        return totaltime / (double)size;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */