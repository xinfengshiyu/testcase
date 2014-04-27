package com.alibaba.china.gene.dal.spu.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.alibaba.china.gene.common.util.SPUZipUtil;

public class TestZip {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\temp\\27");
            int size = (int) file.length();
            byte[] stream = new byte[size];
            InputStream fis = new FileInputStream(file);
            int offset = 0;
            while ((size -= fis.read(stream, offset, size)) > 0) {
                offset = (int) file.length() - size;
            }
            byte[] byteArray = SPUZipUtil.unzip(stream);
            FileOutputStream outputStream = new FileOutputStream(new File("D:\\temp\\27-unzip"));
            outputStream.write(byteArray);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
