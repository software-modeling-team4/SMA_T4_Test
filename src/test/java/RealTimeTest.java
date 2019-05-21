import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class RealTimeTest {

    @Test
    public void getCurrSection(){
        RealTime realTime = new RealTime();
        assertEquals(0, realTime.getCurrSection());
    }

    @Test
    public void nextSection() {
        RealTime realTime = new RealTime();
        realTime.nextSection();
        assertEquals(1, realTime.getCurrSection());
    }

    @Test
    public void increaseTime() {
        RealTime realTime = new RealTime();
        realTime.nextSection();
        realTime.increaseTime();
        assertEquals(1, realTime.requestRealTime().get(Calendar.MINUTE));

        // Test Separate Sections
        for(int i = 0; i < 59; i++)
            realTime.increaseTime();
        assertEquals(0, realTime.requestRealTime().get(Calendar.HOUR));
        assertEquals(0, realTime.requestRealTime().get(Calendar.MINUTE));
    }

    @Test
    public void decreaseTime() {
        RealTime realTime = new RealTime();
        realTime.nextSection();
        realTime.decreaseTime();
        assertEquals(0, realTime.requestRealTime().get(Calendar.MILLISECOND));
        assertEquals(59, realTime.requestRealTime().get(Calendar.MINUTE));
        assertEquals(0, realTime.requestRealTime().get(Calendar.HOUR_OF_DAY));
        assertEquals(1, realTime.requestRealTime().get(Calendar.DATE));
        assertEquals(0, realTime.requestRealTime().get(Calendar.MONTH));
        assertEquals(1970, realTime.requestRealTime().get(Calendar.YEAR));

    }

    @Test
    public void setSecond() {
        RealTime realTime = new RealTime();
        realTime.setSecond(31);
        assertEquals(31,realTime.requestRealTime().get(Calendar.SECOND));
        assertEquals(0, realTime.requestRealTime().get(Calendar.MILLISECOND));
    }

    @Test
    public void calculateTime() {
        RealTime realTime = new RealTime();
        realTime.calculateTime();
        assertEquals(0, realTime.requestRealTime().get(Calendar.SECOND));
        assertEquals(10, realTime.requestRealTime().get(Calendar.MILLISECOND));
    }

    @Test
    public void showRealTime() {
    }
}