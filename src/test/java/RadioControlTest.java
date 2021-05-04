import static org.junit.jupiter.api.Assertions.*;

class RadioControlTest {

    @org.junit.jupiter.api.Test
    public void checkMaxChannel() {
        RadioControl radio = new RadioControl(1_000_000);
        assertEquals(1_000_000, radio.getMaxChannel());
    }

    @org.junit.jupiter.api.Test
    public void setCurrentChannel() {
        RadioControl radio = new RadioControl(100);
        assertEquals(0, radio.getCurrentChannel());
        radio.setCurrentChannel(100);
        assertEquals(100, radio.getCurrentChannel());
    }

    @org.junit.jupiter.api.Test
    public void setCurrentChannelHighThanMax() {
        RadioControl radio = new RadioControl(99);
        assertEquals(0, radio.getCurrentChannel());
        radio.setCurrentChannel(100);
        assertEquals(99, radio.getCurrentChannel());
    }

    @org.junit.jupiter.api.Test
    public void setCurrentChannelLowThanMin() {
        RadioControl radio = new RadioControl(1000);
        assertEquals(0, radio.getCurrentChannel());
        radio.setCurrentChannel(-100);
        assertEquals(0, radio.getCurrentChannel());
    }


    @org.junit.jupiter.api.Test
    public void nextChannelFromMaxCurrent() {
        RadioControl radio = new RadioControl(999);
        radio.setCurrentChannel(999);
        radio.nextChannel();
        assertEquals(0, radio.getCurrentChannel());
    }

    @org.junit.jupiter.api.Test
    public void nextChannelFromMinCurrent() {
        RadioControl radio = new RadioControl();
        radio.setCurrentChannel(0);
        radio.nextChannel();
        assertEquals(1, radio.getCurrentChannel());

    }

    @org.junit.jupiter.api.Test
    public void previousChannelFromMaxCurrent() {
        RadioControl radio = new RadioControl(1000);
        radio.setCurrentChannel(1000);
        radio.previousChannel();
        assertEquals(999, radio.getCurrentChannel());


    }

    @org.junit.jupiter.api.Test
    public void previousChannelFromMinCurrent() {
        RadioControl radio = new RadioControl(3);
        radio.setCurrentChannel(0);
        radio.previousChannel();
        assertEquals(3, radio.getCurrentChannel());

    }

    @org.junit.jupiter.api.Test
    public void setCurrentVolume() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(1);
        assertEquals(1, radio.getCurrentVolume());
    }

    @org.junit.jupiter.api.Test
    public void setCurrentVolumeHighThanMax() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(1000);
        assertEquals(100, radio.getCurrentVolume());
    }

    @org.junit.jupiter.api.Test
    public void setCurrentVolumeLowThanMin() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(-100);
        assertEquals(0, radio.getCurrentVolume());
    }

    @org.junit.jupiter.api.Test
    public void upVolumeFromMaxCurrent() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(100);
        radio.upVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @org.junit.jupiter.api.Test
    public void upVolumeFromMinCurrent() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(0);
        radio.upVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @org.junit.jupiter.api.Test
    public void downVolumeFromMaxCurrent() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(100);
        radio.downVolume();
        assertEquals(99, radio.getCurrentVolume());
    }

    @org.junit.jupiter.api.Test
    public void downVolumeFromMinCurrent() {
        RadioControl radio = new RadioControl();
        radio.setCurrentVolume(0);
        radio.downVolume();
        assertEquals(0, radio.getCurrentVolume());
    }


}