import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class StopwatchTest {

    @Test
    public void realTimeTaskStopwatch() {
    }

    @Test
    public void requestStartStopwatch() {
        Stopwatch stp = new Stopwatch();
        stp.requestStartStopwatch();
        assertEquals(1, stp.getStatus());
    }

    @Test
    public void requestStopStopwatch() {
        Stopwatch stp = new Stopwatch();
        stp.requestStartStopwatch();
        stp.requestStopStopwatch();
        assertEquals(0, stp.getStatus());
    }

    @Test
    public void requestSplitStopwatch() {
    }

    @Test
    public void requestResetStopwatch() {
        Stopwatch stp = new Stopwatch();
        stp.requestStartStopwatch();
        for(int i = 0; i < 10; i++)
            stp.realTimeTaskStopwatch();
        stp.requestStopStopwatch();
        stp.requestResetStopwatch();
        Calendar temp = stp.getStpTime();
        assertEquals(0, temp.get(Calendar.MILLISECOND));
    }

    @Test
    public void showStopwatch() {
    }
}