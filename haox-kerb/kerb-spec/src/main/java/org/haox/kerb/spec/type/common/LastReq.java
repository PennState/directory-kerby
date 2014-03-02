package org.haox.kerb.spec.type.common;

import java.util.List;

/**
 LastReq         ::=     SEQUENCE OF SEQUENCE {
 lr-type         [0] Int32,
 lr-value        [1] KrbTime
 }
 */
public class LastReq {
    private List<LastReqEntry> entries;

    public List<LastReqEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<LastReqEntry> entries) {
        this.entries = entries;
    }
}
