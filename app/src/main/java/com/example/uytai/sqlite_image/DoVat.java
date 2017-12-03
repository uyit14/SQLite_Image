package com.example.uytai.sqlite_image;

/**
 * Created by uytai on 12/3/2017.
 */

public class DoVat {
    private int Id;
    private byte[] Hinh;

    public DoVat(int id, byte[] hinh) {
        Id = id;
        Hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }
}
