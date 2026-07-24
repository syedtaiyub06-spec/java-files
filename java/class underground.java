import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkInMap = new HashMap<>();
    private Map<String, double[]> routeMap = new HashMap<>();

    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    public UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMap.remove(id);
        String key = info.stationName + "->" + stationName;
        double[] stats = routeMap.computeIfAbsent(key, k -> new double[2]);
        stats[0] += t - info.time;
        stats[1] += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] stats = routeMap.get(startStation + "->" + endStation);
        return stats[0] / stats[1];
    }
}