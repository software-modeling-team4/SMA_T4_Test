public class WatchSystem {

    private Mode[] menu;
    private int currMode;
    private int maxCnt;

    public static void main(String[] args) {
      SeparateSection test = new SeparateSection();
      test.test();
    //    WatchSystem run = new WatchSystem();
    }

    public WatchSystem() {
        TimeThread thread = new TimeThread(this);

        //System_GUI system_gui = new System_GUI(this);
        //Time timeLive = new Time(55, 59, 23);
        this.menu = new Mode[]{
                new RealTime(),
                new TimeSetting(),
                new Stopwatch(),
                new Timer(),
                new Alarm()
        };

        ((TimeSetting)this.menu[1]).setRealTime((RealTime)this.menu[0]);

        this.currMode = 0;
        this.maxCnt = 4;
        thread.run();
    }

    public void pressShowType() {
        /*
        RealTime realTime = (RealTime) presentMenu;
        if (realTime.is24Hour) realTime.is24Hour = false;
        else realTime.is24Hour = true;
        */
    }


    public void pressChangeMode() {
        if(++this.currMode == this.maxCnt)
            this.currMode = 0;
    }


    // Worked by thread
    public void realTimeTask() {
        for(int i = 0; i <= this.maxCnt; i++){
            if(this.menu[i] instanceof RealTime){
                ((RealTime)this.menu[i]).calculateTime();
                if(this.currMode == i)
                    ((RealTime)this.menu[i]).showRealTime();
                continue;
            }

            else if(this.menu[i] instanceof TimeSetting){
                ((TimeSetting)this.menu[i]).realTimeTaskTimeSetting();
                if(this.currMode == i)
                    ((TimeSetting)this.menu[i]).getRealTime().showRealTime();
                continue;
            }

            else if(this.menu[i] instanceof Stopwatch){
                ((Stopwatch) this.menu[i]).realTimeTaskStopwatch();
                if(this.currMode == i)
                    ((Stopwatch)this.menu[i]).showStopwatch();
                continue;
            }

            else if(this.menu[i] instanceof Timer){
                ((Timer) this.menu[i]).realTimeTimerTask();
                if(this.currMode == i)
                    ((Timer)this.menu[i]).showTimer();
                continue;
            }

            else if(this.menu[i] instanceof Alarm){
                ((Alarm) this.menu[i]).realTimeTaskAlarm();
                if(this.currMode == i)
                    ((Alarm)this.menu[i]).showAlarm();
                continue;
            }

            else if(this.menu[i] instanceof Worldtime){
                ((Worldtime) this.menu[i]).realTimeTaskWorldtime();
                if(this.currMode == i)
                    ((Worldtime)this.menu[i]).showWorldTime();
                continue;
            }

            else if(this.menu[i] instanceof Sun){
                ((Sun) this.menu[i]).realTimeTaskSun();
                if(this.currMode == i)
                    ((Sun)this.menu[i]).showSun();
                continue;
            }
            else{
                System.out.println("{Exception}[WatchSystem][realTimeTask] NotValidModeException");
                return ;
            }
        }
    }

}
