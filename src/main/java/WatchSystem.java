import javafx.scene.paint.Stop;

import java.util.ArrayList;

public class WatchSystem {

    private ArrayList<Mode> menu;
    private int currMode;
    private int maxCnt;

    public static void main(String[] args) {
      SeparateSection test = new SeparateSection();
      System.out.println(test.getClass().getTypeName());
      WatchSystem run = new WatchSystem();
      run.realTimeTask();
    }

    public WatchSystem() {
        //TimeThread thread = new TimeThread(this);

        //System_GUI system_gui = new System_GUI(this);
        //Time timeLive = new Time(55, 59, 23);
        this.menu = new ArrayList<Mode>();
        this.menu.add(new RealTime());
        this.menu.add(new TimeSetting((RealTime)this.menu.get(0)));
        this.menu.add(new Stopwatch());
        this.menu.add(new Timer());
        this.menu.add(new Alarm((RealTime)this.menu.get(0)));

        this.currMode = 0; // [currMode] 0: Always RealTime
        this.maxCnt = 4;
        //thread.run();
    }

    public void pressShowType() {
        if(this.menu.get(this.currMode) instanceof RealTime)
            ((RealTime)this.menu.get(this.currMode)).requestChangeType();
    }

    // Worked by thread
    public void realTimeTask() {
        for(int i = 0; i <= this.maxCnt; i++){
            Mode menu = this.menu.get(i);
            switch(menu.getClass().getTypeName()) {
                case "RealTime":
                    ((RealTime) menu).calculateTime();
                    if (this.currMode == i) ((RealTime) menu).showRealTime();
                    break;

                case "TimeSetting":
                    ((TimeSetting) menu).realTimeTaskTimeSetting();
                    if (this.currMode == i) ((TimeSetting) menu).getRealTime().showRealTime();
                    break;

                case "Stopwatch":
                    ((Stopwatch) menu).realTimeTaskStopwatch();
                    if (this.currMode == i) ((Stopwatch) menu).showStopwatch();
                    break;

                case "Timer":
                    ((Timer) menu).realTimeTimerTask();
                    if (this.currMode == i) ((Timer) menu).showTimer();
                    break;

                case "Alarm":
                    ((Alarm) menu).realTimeTaskAlarm();
                    if (this.currMode == i) ((Alarm) menu).showAlarm();
                    break;

                case "Worldtime":
                    ((Worldtime) menu).realTimeTaskWorldtime();
                    if (this.currMode == i) ((Worldtime) menu).showWorldTime();
                    break;

                case "Sun":
                    ((Sun) menu).realTimeTaskSun();
                    if (this.currMode == i) ((Sun) menu).showSun();
                    break;

                default:
                    System.out.println("{Exception}[WatchSystem][realTimeTask] NotValidModeException");
                    break;
            }
        }
    }

    public void pressChangeMode() {
        if(++this.currMode == this.maxCnt)
            this.currMode = 0;
    }

    /*
    public void callNextMode(){
        if(++this.currMode == this.maxCnt)
            this.currMode = 0; // 0: RealTime
    }
    */

    // Mode Setting
    public void enterModeSetting(){}
    public void pressNextMode(){}
    public void pressSelectMode(){}
    public void confirmSelectMode(){}
    public void exitSelectMode(){}

    // Time Setting
    public void nextTimeSection(){ ((TimeSetting)this.menu.get(this.currMode)).requestPointNextTimeSection(); }
    public void increaseTimeSection(){ ((TimeSetting)this.menu.get(this.currMode)).requestIncreaseTimeSection(); }
    public void decreaseTimeSection(){ ((TimeSetting)this.menu.get(this.currMode)).requestDecreaseTimeSection(); }
    public void pressResetSecond(){ ((TimeSetting)this.menu.get(this.currMode)).requestResetSecond(); }

    // Stopwatch
    public void pressStartStopwatch(){ ((Stopwatch)this.menu.get(this.currMode)).requestStartStopwatch(); }
    public void pressStopStopwatch(){ ((Stopwatch)this.menu.get(this.currMode)).requestStopStopwatch(); }
    public void pressSplitStopwatch(){ ((Stopwatch)this.menu.get(this.currMode)).requestSplitStopwatch(); }
    public void pressResetStopwatch(){ ((Stopwatch)this.menu.get(this.currMode)).requestResetStopwatch(); }

    // Timer
    public void enterSetTimerTime(){ ((Timer)this.menu.get(this.currMode)).requestTimerTime(); }
    public void nextTimerTimeSection(){ ((Timer)this.menu.get(this.currMode)).requestNextTimerTimeSection(); }
    public void increaseTimerTimeSection(){ ((Timer)this.menu.get(this.currMode)).requestIncreaseTimerTimeSection(); }
    public void decreaseTimerTimeSection(){ ((Timer)this.menu.get(this.currMode)).requestDecreaseTimerTimeSection(); }
    public void exitSetTimerTime(){ ((Timer)this.menu.get(this.currMode)).requestExitSetTimerTime(); }
    public void pressStartTimer(){ ((Timer)this.menu.get(this.currMode)).changeStatus(1); }
    public void pressStopTimer(){ ((Timer)this.menu.get(this.currMode)).changeStatus(0); }
    public void pressStopRingingTimer(){ ((Timer)this.menu.get(this.currMode)).ringOff(); }

    // Alarm
    public void enterSetAlarmTime(){ ((Alarm)this.menu.get(this.currMode)).requestSettingAlarm(); }
    public void nextAlarmTimeSection(){}
    public void increaseAlarmTime(){ ((Alarm)this.menu.get(this.currMode)).increaseSection(); }
    public void decreaseAlarmTime(){ ((Alarm)this.menu.get(this.currMode)).decreaseSection(); }
    public void enterSetAlarmFrequency(){}
    public void nextFrequencySection(){}
    public void increaseCount(){}
    public void increaseFrequency(){}
    public void decreaseCount(){}
    public void decreaseFrequency(){}
    public void enterSetAlarmBell(){}
    public void nextBell(){}
    public void prevBell(){}
    public void pressNextAlarm(){ ((Alarm)this.menu.get(this.currMode)).requestNextAlarm(); }
    public void pressStopRingingAlarm(){ ((Alarm)this.menu.get(this.currMode)).requestStopRinging(); }
    public void pressAlarmOnOff(){ ((Alarm)this.menu.get(this.currMode)).requestAlarmOnOff(); }

    // Worldtime
    public void nextWorldtimeCity(){ ((Worldtime)this.menu.get(this.currMode)).nextCity(); }
    public void prevWorldtimeCity(){ ((Worldtime)this.menu.get(this.currMode)).prevCity(); }
    public void pressSummerTime(){ ((Worldtime)this.menu.get(this.currMode)).changeSummerTime(); }

    // Sun
    public void pressSetRise(){ ((Sun)this.menu.get(this.currMode)).requestSetRise(); }
    public void nextSunCity(){ ((Sun)this.menu.get(this.currMode)).requestNextCity(); }
    public void prevSunCity(){ ((Sun)this.menu.get(this.currMode)).requestPrevCity(); }
}
