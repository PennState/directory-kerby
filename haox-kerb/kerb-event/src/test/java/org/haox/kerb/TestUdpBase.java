package org.haox.kerb;

import java.nio.ByteBuffer;

public class TestUdpBase {
    protected String serverHost = "127.0.0.1";
    protected short serverPort = 8181;
    protected String TEST_MESSAGE = "Hello world!";
    protected String clientRecvedMessage;

    protected String recvBuffer2String(ByteBuffer buffer) {
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return new String(bytes);
    }
}
