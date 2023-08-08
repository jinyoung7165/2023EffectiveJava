package ch1.item1.domain;

import lombok.Data;

import static ch1.item1.domain.StudyStatus.DRAFT;
import static ch1.item1.domain.StudyStatus.ENDED;

@Data
public class Study {
    private Long id;
    private String name;
    private int limit;
    private StudyStatus studyStatus;

    private Study(String name, int limit, StudyStatus studyStatus) {
        this.name = name;
        this.limit = limit;
        this.studyStatus = DRAFT;
    }

    public static Study newStudy(String name, int limit) {
        return new Study(name, limit, DRAFT);
    }

    public static Study endedStudy(String name, int limit) {
        return new Study(name, limit, ENDED);
    }

}
