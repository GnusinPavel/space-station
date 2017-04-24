package ru.codeinside.spacestation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class BypassEnterpriseTest extends Assert {

    @Parameter
    public int stateRoomsNumber;

    @Parameters
    public static Collection<Integer> parameters() {
        return Arrays.asList(1, 9, 99, 150, 999);
    }

    @Test
    public void howManyStaterooms() throws Exception {
        final int actualRoomsNumber = new JeanLucPicard(
                new Enterprise(
                        randomRooms()
                )
        ).stateroomsNumber();

        assertEquals(stateRoomsNumber, actualRoomsNumber);
    }

    private List<Room> randomRooms() {
        Random random = new Random(System.currentTimeMillis());
        final List<Room> rooms = new ArrayList<>(stateRoomsNumber);
        for (int i = 0; i < stateRoomsNumber; i++) {
            int someRandomInt = random.nextInt(1000);
            rooms.add(new Stateroom(someRandomInt > 500));
        }
        return rooms;
    }
}
