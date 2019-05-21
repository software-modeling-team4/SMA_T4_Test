import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void realTimeTaskAlarm() {
    }

    @Test
    public void requestSettingAlarm() {
        Alarm alarm = new Alarm();
        alarm.requestSettingAlarm();
        assertEquals(1, alarm.getStatus());
    }

    @Test
    public void requestAlarmNextSection() {
        Alarm alarm = new Alarm();
        //alarm.req
    }

    @Test
    public void increaseSection() {
    }

    @Test
    public void decreaseSection() {
    }

    @Test
    public void requestSettingBellAlarm() {
    }

    @Test
    public void requestAlarmPrevSection() {
    }

    @Test
    public void requestNextAlarm() {
        Alarm alarm = new Alarm();
        assertEquals(0, alarm.getCurrAlarm());
        alarm.requestNextAlarm();
        assertEquals(1, alarm.getCurrAlarm());
        alarm.setCurrAlarm(3);
        alarm.requestNextAlarm();
        assertEquals(0, alarm.getCurrAlarm());
    }

    @Test
    public void requestStopRinging() {
    }

    @Test
    public void requestAlarmOnOff() {
        Alarm alarm = new Alarm();
        alarm.requestAlarmOnOff();
        assertEquals(true, alarm.getAlarmCurrAlarmStatus());

        alarm.requestAlarmOnOff();
        assertEquals(false, alarm.getAlarmCurrAlarmStatus());
    }
}