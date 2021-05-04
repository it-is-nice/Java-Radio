package ru.netology;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


public class RadioControl {
    private int currentChannel;
    private int maxChannel = 10;
    private int minChannel = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;

   /* public int getMaxChannel() {
        return maxChannel;
    }


    public int getCurrentChannel() {
        return currentChannel;
    }*/


    public RadioControl(int maxChannel) {
        this.maxChannel = maxChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        if (currentChannel < minChannel) {
            currentChannel = minChannel;
        }
        if (currentChannel > maxChannel) {
            currentChannel = maxChannel;
        }
        this.currentChannel = currentChannel;
    }

   /* public int getCurrentVolume() {
        return currentVolume;
    }*/

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume) {
            currentVolume = minVolume;
        }
        if (currentVolume > maxVolume) {
            currentVolume = maxVolume;
        }
        this.currentVolume = currentVolume;
    }

    public void nextChannel(){
        if (currentChannel < maxChannel) {
            currentChannel++;
        }
        else {currentChannel = minChannel;}
    }
    public void previousChannel(){
        if (currentChannel > minChannel){
            currentChannel--;
        }
        else {currentChannel = maxChannel;}
    }

    public void upVolume(){
        if (currentVolume < maxVolume){
            currentVolume++;
        }
        else {currentVolume = maxVolume;}
    }
    public void downVolume(){
        if (currentVolume > minVolume){
            currentVolume--;
        }
        else {currentVolume = minVolume;}
    }

}
