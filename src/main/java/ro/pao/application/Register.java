package ro.pao.application;

import ro.pao.model.PairInfo;
import ro.pao.service.StudentService;
import ro.pao.service.impl.StudentServiceImpl;

import java.util.Map;
import java.util.UUID;

public final class Register {
    private static Register INSTANCE = null;

    private static StudentService studentService = new StudentServiceImpl();
    private static Map<UUID, PairInfo> courseStudentMap;

    public static Register getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Register();
        }
        return INSTANCE;
    }
}
