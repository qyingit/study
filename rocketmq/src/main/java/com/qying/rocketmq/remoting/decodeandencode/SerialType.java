package com.qying.rocketmq.remoting.decodeandencode;

public enum  SerialType {

    JSON((byte) 0),
    ROCKETMQ((byte)1);

    private byte code;

    SerialType(byte code) {
        this.code = code;
    }
    public static SerialType valueOf(byte code) {
        for (SerialType serializeType : SerialType.values()) {
            if (serializeType.getCode() == code) {
                return serializeType;
            }
        }
        return null;
    }

    public byte getCode() {
        return code;
    }
}
