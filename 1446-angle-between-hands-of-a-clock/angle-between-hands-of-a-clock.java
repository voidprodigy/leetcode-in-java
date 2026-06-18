class Solution {
    public double angleClock(int hour, int minutes) {

        // Convert 12 to 0 because both point to the same position
        hour %= 12;

        // Angle made by the hour hand
        // 30 degrees for each hour + 0.5 degrees for each minute
        double hourAngle = hour * 30 + minutes * 0.5;

        // Angle made by the minute hand
        // 6 degrees for each minute
        double minuteAngle = minutes * 6;

        // Absolute difference between the two angles
        double diff = Math.abs(hourAngle - minuteAngle);

        // Return the smaller angle
        return Math.min(diff, 360 - diff);
    }
}