package ch2.item1;

import ch2.item1.domain.ClassRoom;
import ch2.item1.domain.Study;
import ch2.item1.factory.ClassRoomFactory;
import ch2.item1.factory.StudyFactory;

import java.rmi.NoSuchObjectException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StudyApplication {
    public static void main(String[] args) throws NoSuchObjectException {
        StudyFactory studyFactory = StudyFactory.getInstance();
        Study study = studyFactory.getStudy("수학", 25);

        ClassRoom classRoom = ClassRoomFactory.getClassRoom(study.getLimit());

        System.out.println("study = " + study);
        System.out.println("classRoom = " + classRoom.getCapacity());
    }
}