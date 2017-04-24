package ru.codeinside.spacestation;

import java.util.List;

public class Enterprise implements Spaceship {
    private final List<Room> rooms;
    private int currentPosition = 0;

    public Enterprise(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void next() {
        currentPosition += 1;
        if (currentPosition >= rooms.size()) {
            currentPosition = 0;
        }
    }

    @Override
    public Room current() {
        return new CacheRoom(rooms.get(currentPosition));
    }

    @Override
    public void previous() {
        currentPosition -= 1;
        if (currentPosition <= -1) {
            currentPosition = rooms.size() - 1;
        }
    }

    private static class CacheRoom implements Room {
        private final Room originRoom;
        private final boolean originLightValue;

        private CacheRoom(Room originRoom) {
            this.originRoom = originRoom;
            this.originLightValue = originRoom.isLightOn();
        }

        @Override
        public void turnOn() {
            originRoom.turnOn();
        }

        @Override
        public void turnOff() {
            originRoom.turnOff();
        }

        @Override
        public boolean isLightOn() {
            return originLightValue;
        }
    }
}
