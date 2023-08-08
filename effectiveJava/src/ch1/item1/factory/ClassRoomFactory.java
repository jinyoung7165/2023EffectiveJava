package ch1.item1.factory;

import ch1.item1.domain.BigClassRoom;
import ch1.item1.domain.ClassRoom;

import java.rmi.NoSuchObjectException;
import java.util.Objects;

public class ClassRoomFactory {
    public static final String NOT_FOUND_CLASS_ROOM_FROM_LIMIT_COUNT = "Not Found ClassRoom from limitCount:";
    private static ClassRoomFactory instance = new ClassRoomFactory();

    private ClassRoomFactory() {}

    public static ClassRoomFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ClassRoomFactory();
        }
        return instance;
    }

    public ClassRoom getClassRoom(int limitCount) throws NoSuchObjectException {
        if (BigClassRoom.supported(limitCount)) {
            return new BigClassRoom();
        }
        throw new NoSuchObjectException(NOT_FOUND_CLASS_ROOM_FROM_LIMIT_COUNT + limitCount);
    }
}
