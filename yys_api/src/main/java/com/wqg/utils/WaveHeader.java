package com.wqg.utils;

public class WaveHeader {

    public static byte[] RIFF = "RIFF".getBytes();
    public static byte[] RIFF_SIZE = new byte[8];
    public static byte[] RIFF_TYPE = "WAVE".getBytes();
    public static byte[] FORMAT = "fmt ".getBytes();
    public static byte[] FORMAT_SIZE = new byte[4];

    public static byte[] FORMAT_TAG = new byte[2];
    public static byte[] CHANNELS = new byte[2];
    public static byte[] SamplesPerSec = new byte[4];
    public static byte[] AvgBytesPerSec = new byte[4];
    public static byte[] BlockAlign = new byte[2];
    public static byte[] BitsPerSample = new byte[2];
    public static byte[] Data = "data".getBytes();
    public static byte[] DataSize = new byte[4];

    public static void init() {
        FORMAT_SIZE = new byte[]{(byte) 16, (byte) 0, (byte) 0, (byte) 0};
        byte[] tmp = revers(intToBytes(1));
        FORMAT_TAG = new byte[]{tmp[0], tmp[1]};
        CHANNELS = new byte[]{tmp[0], tmp[1]};
        SamplesPerSec = revers(intToBytes(16000));
        AvgBytesPerSec = revers(intToBytes(32000));
        tmp = revers(intToBytes(2));
        BlockAlign = new byte[]{tmp[0], tmp[1]};
        tmp = revers(intToBytes(16));
        BitsPerSample = new byte[]{tmp[0], tmp[1]};
    }

    public static byte[] revers(byte[] tmp) {
        byte[] reversed = new byte[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            reversed[i] = tmp[tmp.length - i - 1];
        }
        return reversed;
    }

    public static byte[] intToBytes(int num) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (num >> 24);
        bytes[1] = (byte) ((num >> 16) & 0x000000FF);
        bytes[2] = (byte) ((num >> 8) & 0x000000FF);
        bytes[3] = (byte) (num & 0x000000FF);
        return bytes;
    }
}












