package com.example.buyer.encrypt;

import java.security.MessageDigest;

/**
 * @Author: Lishenglong
 * @Date: 2022/2/8 21:53
 */
public class MD5 {

    public String getMD5ofStr(String strSrc) {
        MessageDigest md = null;
        MD5 mept = new MD5();
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(bt);
            strDes = mept.bytes2Hex(md.digest()); //to HexString
        } catch (Exception e) {
            System.out.println("Invalid algorithm.\n" + e.getMessage());
            return null;
        }
        return strDes;
    }

    private String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;

        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
