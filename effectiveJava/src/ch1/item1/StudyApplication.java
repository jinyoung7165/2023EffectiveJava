package ch1.item1;

import ch1.item1.domain.ClassRoom;
import ch1.item1.domain.Study;
import ch1.item1.factory.ClassRoomFactory;
import ch1.item1.factory.StudyFactory;

import java.rmi.NoSuchObjectException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StudyApplication {
    public static void main(String[] args) throws NoSuchObjectException {
        StudyFactory studyFactory = StudyFactory.getInstance();
        Study study = studyFactory.getStudy("수학", 25);
        ClassRoomFactory classRoomFactory = ClassRoomFactory.getInstance();
        ClassRoom classRoom = classRoomFactory.getClassRoom(study.getLimit());

        System.out.println("study = " + study);
        System.out.println("classRoom = " + classRoom.getCapacity());
    }
}