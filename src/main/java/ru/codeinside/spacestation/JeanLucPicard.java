package ru.codeinside.spacestation;

public class JeanLucPicard implements Captain {

    private final Spaceship spaceship;

    public JeanLucPicard(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public int stateroomsNumber() {
        // todo: implement logic here
        return 0;
    }
}
