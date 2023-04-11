package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Packet {
    private String sourceMac;
    private String destMac;
    private String data;
    private int crc;

    public Packet(String sourceMac, String destMac, String data, int crc) {
        this.sourceMac = sourceMac;
        this.destMac = destMac;
        this.data = data;
        this.crc = crc;
    }

    public String getSourceMac() {
        return sourceMac;
    }

    public void setSourceMac(String sourceMac) {
        this.sourceMac = sourceMac;
    }

    public String getDestMac() {
        return destMac;
    }

    public void setDestMac(String destMac) {
        this.destMac = destMac;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCrc() {
        return crc;
    }

    public void setCrc(int crc) {
        this.crc = crc;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "sourceMac='" + sourceMac + '\'' +
                ", destMac='" + destMac + '\'' +
                ", data='" + data + '\'' +
                ", crc=" + crc +
                '}';
    }
    
    public byte[] serialize() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.flush();
        return outputStream.toByteArray();
    }
}

