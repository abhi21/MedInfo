package com.thoughtworks.medinfo.model;

import java.util.ArrayList;
import java.util.List;

public enum  HCPRole {
     ANGANWADI_WORKER, DOCTOR, MIDWIFE, HOSPITAL, ASHA, ANM;

    public List getRoles() {
        List<String> roles = new ArrayList<String>();
        for (HCPRole role : HCPRole.values()) {
            roles.add(role.toString());
        }
        return roles;
    }
}
