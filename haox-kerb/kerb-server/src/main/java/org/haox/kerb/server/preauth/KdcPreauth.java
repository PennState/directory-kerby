package org.haox.kerb.server.preauth;

import org.haox.kerb.preauth.PaFlags;
import org.haox.kerb.preauth.PluginRequestContext;
import org.haox.kerb.preauth.PreauthPluginMeta;
import org.haox.kerb.server.KdcContext;
import org.haox.kerb.server.request.KdcRequest;
import org.haox.kerb.spec.KrbException;
import org.haox.kerb.spec.type.pa.PaData;
import org.haox.kerb.spec.type.pa.PaDataEntry;
import org.haox.kerb.spec.type.pa.PaDataType;

/**
 * KDC side preauth plugin module
 */
public interface KdcPreauth extends PreauthPluginMeta {

    public void init(KdcContext context);

    /**
     * Initializing request context
     */
    public PluginRequestContext initRequestContext(KdcRequest kdcRequest);

    /**
     * Optional: provide pa_data to send to the client as part of the "you need to
     * use preauthentication" error.
     */
    public void provideEdata(KdcRequest kdcRequest, PluginRequestContext requestContext,
                             PaData outPaData) throws KrbException;

    /**
     * Optional: verify preauthentication data sent by the client, setting the
     * TKT_FLG_PRE_AUTH or TKT_FLG_HW_AUTH flag in the enc_tkt_reply's "flags"
     * field as appropriate.
     */
    public void verify(KdcRequest kdcRequest, PluginRequestContext requestContext,
                       PaDataEntry paData) throws KrbException;

    /**
     * Optional: generate preauthentication response data to send to the client as
     * part of the AS-REP.
     */
    public void providePaData(KdcRequest kdcRequest, PluginRequestContext requestContext,
                              PaData paData);

    /**
     * Return PA_REAL if pa_type is a real preauthentication type or PA_INFO if it is
     * an informational type.
     */
    public PaFlags getFlags(KdcRequest kdcRequest, PluginRequestContext requestContext,
                            PaDataType paType);

    /**
     * When exiting...
     */
    public void destroy();

}
