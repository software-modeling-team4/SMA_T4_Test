import java.util.Calendar;

public class Alarm implements Mode {

    private Calendar[] reservated;
    private int[] frequency;
    private int[] repeat;
    private boolean[] alarmState;

    private int status; // 0: List, 1: Alarm Time Setting, 2: Alarm Frequency, 3: Alarm Bell Setting
    private int currAlarm;
    private RealTime realTime;

    public Alarm(){
        this.reservated = new Calendar[4];
        for(Calendar cal : this.reservated){
            cal = Calendar.getInstance();
            cal.clear();
        }

        this.frequency = new int[]{0,0,0,0};
        this.repeat = new int[]{0,0,0,0};
        this.alarmState = new boolean[]{false, false, false, false};

        this.status = 0;
        this.currAlarm = 0;
        this.realTime = null;
    }

    // Getters and Setters
    public Calendar[] getReservated() { return reservated; }
    public void setReservated(Calendar[] reservated) { this.reservated = reservated; }
    public int[] getFrequency() { return frequency; }
    public int getFrequency(int i){ return frequency[i]; }
    public void setFrequency(int[] frequency) { this.frequency = frequency; }
    public void setFrequency(int i, int frequency) { this.frequency[i] = frequency; }
    public int[] getRepeat() { return repeat; }
    public int getRepeat(int i){ return repeat[i]; }
    public void setRepeat(int[] repeat) { this.repeat = repeat; }
    public void setRepeat(int i, int repeat) { this.repeat[i] = repeat; }
    public int getStatus() { return status; }
    public void setStatus(int status ) { this.status = status; }
    public RealTime getRealTime() { return realTime; }
    public void setRealTime(RealTime realTime) { this.realTime = realTime; }

    public void realTimeTaskAlarm(){}
    public void requestSettingAlarm(){
        if(this.status == 0)
            this.status = 1;
    }
    public void requestAlarmNextSection(){}
    public void increaseSection(){}
    public void decreaseSection(){}
    //public void requestAlarmNextSection(){}
    public void requestSettingBellAlarm(){}
    public void requestAlarmPrevSection(){}
    public void requestNextAlarm(){
        if(++this.currAlarm == 4)
            this.currAlarm = 0;
    }
    public void requestStopRinging(){}
    public void requestAlarmOnOff(){ this.alarmState[this.currAlarm] = !this.alarmState[this.currAlarm]; }
    public void showAlarm(){}
}
