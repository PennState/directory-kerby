/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.kerby.kerberos.kerb.server.request;

import org.apache.kerby.kerberos.kerb.spec.base.TransitedEncoding;
import org.apache.kerby.kerberos.kerb.spec.base.TransitedEncodingType;

/**
 * Issuing TGT ticket.
 */
public class TgtTicketIssuer extends TicketIssuer {

    public TgtTicketIssuer(AsRequest kdcRequest) {
        super(kdcRequest);
    }

    @Override
    protected TransitedEncoding getTransitedEncoding() {
        TransitedEncoding transEnc = new TransitedEncoding();
        transEnc.setTrType(TransitedEncodingType.DOMAIN_X500_COMPRESS);
        byte[] empty = new byte[0];
        transEnc.setContents(empty);

        return transEnc;
    }
}
