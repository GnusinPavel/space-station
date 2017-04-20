package ru.codeinside.spacestation;

public class JeanLucPicard implements Captain {

    private final StateroomVisiting stateroomVisiting;

    public JeanLucPicard(StateroomVisiting stateroomVisiting) {
        this.stateroomVisiting = stateroomVisiting;
    }

    @Override
    public int stateroomsNumber() {
        // todo: implement logic here
        return 0;
    }
}
