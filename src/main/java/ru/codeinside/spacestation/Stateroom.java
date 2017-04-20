package ru.codeinside.spacestation;

public class Stateroom implements Lightning {
    private boolean theLightIsOn;

    public Stateroom(boolean theLightIsOn) {
        this.theLightIsOn = theLightIsOn;
    }

    @Override
    public void turnOn() {
        theLightIsOn = true;
    }

    @Override
    public void turnOff() {
        theLightIsOn = false;
    }

    @Override
    public boolean value() {
        return theLightIsOn;
    }
}
