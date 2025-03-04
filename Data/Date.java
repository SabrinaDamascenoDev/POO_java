public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDate(int day, int month, int year){
        this.day = day;
        this.year = year;
        this.month = month;
    }



    public String toString(){
        if(day < 10 && month >= 10){
            return "0" + this.day + "/" + this.month + "/" + this.year;
        } else if(day < 10 && month < 10){
            return "0" + this.day + "/0" + this.month + "/" + this.year;
        } else if(day>10 && month < 10){
            return this.day + "/0" + this.month + "/" + this.year;
        } else {
            return this.day + "/" + this.month + "/" + this.year;
        }
    }
}
