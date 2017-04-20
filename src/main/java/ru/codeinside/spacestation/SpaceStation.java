package ru.codeinside.spacestation;

import java.util.List;

public class SpaceStation implements StateroomVisiting {
    private final List<Lightning> lightnings;
    private int currentPosition = 0;

    public SpaceStation(List<Lightning> lightnings) {
        this.lightnings = lightnings;
    }

    @Override
    public void next() {
        currentPosition += 1;
        if (currentPosition >= lightnings.size()) {
            currentPosition = 0;
        }
    }

    @Override
    public Lightning current() {
        return new CacheStateroom(lightnings.get(currentPosition));
    }

    @Override
    public void previous() {
        currentPosition -= 1;
        if (currentPosition <= -1) {
            currentPosition = lightnings.size() - 1;
        }
    }

    private static class CacheStateroom implements Lightning {
        private final Lightning origin;
        private final boolean originValue;

        private CacheStateroom(Lightning origin) {
            this.origin = origin;
            this.originValue = origin.value();
        }

        @Override
        public void turnOn() {
            origin.turnOn();
        }

        @Override
        public void turnOff() {
            origin.turnOff();
        }

        @Override
        public boolean value() {
            return originValue;
        }
    }
}
