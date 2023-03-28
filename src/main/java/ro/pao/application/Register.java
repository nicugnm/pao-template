package ro.pao.application;

import ro.pao.model.PairInfo;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.Map;
import java.util.UUID;

public final class Register extends AbstractEntity {
    private static Register INSTANCE = null;
    private static Map<UUID, PairInfo> courseStudentMap;

    public Register getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Register();
        }
        return INSTANCE;
    }
}
