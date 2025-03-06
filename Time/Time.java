public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int hour, int minute, int second){
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public String toString(){
        if(hour < 10 && minute < 10 && hour < 10){
            return "0" + hour + ":0" + minute + ":0" + second;
        } else if(hour < 10 && minute < 10 && hour >= 10){
            return "0" + hour + ":0" + minute + ":" + second;
        } else if(hour < 10 && minute >= 10 && hour < 10){
            return "0" + hour + ":" + minute + ":0" + second;
        } else if(hour >= 10 && minute < 10 && hour < 10){
            return hour + ":0" + minute + ":0" + second;
        } else if(hour >= 10 && minute >= 10 && hour < 10){
            return hour + ":" + minute + ":0" + second;
        }  else if(hour >= 10 && minute < 10 && hour >= 10){
            return hour + ":0" + minute + ":" + second;
        } else {
            return "0" + hour + ":" + minute + ":" + second;
        }
    }

}
