import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class TimerTest {

    @Test
    public void getTimerTime() {
    }

    @Test
    public void requestTimerTime() {
        Timer timer = new Timer();
        timer.requestTimerTime();
        assertEquals(2, timer.getStatus());
    }

    @Test
    public void requestNextTimerTimeSection() {
        Timer timer = new Timer();
        timer.setCurrSection(2); // Last Section
        timer.requestNextTimerTimeSection();
        assertEquals(0, timer.getCurrSection());
    }

    @Test
    public void requestIncreaseTimerTimeSection() {
        Timer timer = new Timer();
        timer.requestIncreaseTimerTimeSection();
        assertEquals(1, timer.getRsvTime().get(Calendar.SECOND));
        assertEquals(0, timer.getRsvTime().get(Calendar.MILLISECOND));
    }

    @Test
    public void requestDecreaseTimerTimeSection() {
        Timer timer = new Timer();
        Calendar testTime = Calendar.getInstance();
        testTime.set(1970, 1-1, 0, 22, 37, 0);
        testTime.set(Calendar.MILLISECOND, 0);

        timer.setRsvTime(testTime);
        timer.requestDecreaseTimerTimeSection();

        assertEquals(37, timer.getRsvTime().get(Calendar.MINUTE));
        assertEquals(59, timer.getRsvTime().get(Calendar.SECOND));
    }

    @Test
    public void changeStatus() {
        Timer timer = new Timer();
        timer.changeStatus(1);
        assertEquals(1, timer.getStatus());
    }

    @Test
    public void requestResetTimer() {
        Timer timer = new Timer();
        Calendar testTime = Calendar.getInstance();
        testTime.set(1970, 1-1, 0, 22, 34, 30);
        testTime.set(Calendar.MILLISECOND, 0);

        timer.setRsvTime(testTime);
        timer.requestResetTimer();

        assertEquals(34, timer.getTimerTime().get(Calendar.MINUTE));
    }

    @Test
    public void ringOff() {
    }

    @Test
    public void realTimeTimerTask() {
    }

    @Test
    public void showTimer() {
    }

    @Test
    public void requestExitSetTimerTime() {
    }
}