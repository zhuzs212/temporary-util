package com.zzs.temporaryutil.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * 请求 DATA 加密/解密工具类
 *
 * @author zhuzs
 * @date 2022/7/15 10:36
 */
@Slf4j
public class QEncodeUtil {
    /**
     * 加密
     *
     * @param sSrc
     * @param sKey
     * @param datasecretiv 消息密钥初始化向量 用户 AES 加密过程的混合加密，16 位字符
     * @return
     */
    public static String encrypt(String sSrc, String sKey, String datasecretiv) {
        try {
            if (sKey == null) {
                return null;
            }
            // 判断 Key 是否为 16 位
            if (sKey.length() != 16) {
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //"算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec(datasecretiv.getBytes());
            //使用 CBC 模式，需要一个向量 iv，可增加加密算法的强度 1234567890123456
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());
            String str = Base64.getEncoder().encodeToString(encrypted);
            str = str.replaceAll("\r", "");
            str = str.replaceAll("\n", "");
            return str;
            //new BASE64Encoder().encode(encrypted);
            // 此处使用 BASE64 做转码功能，同时能起到 2 次加密的作用。
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 解密
     *
     * @param sSrc
     * @param sKey
     * @param datasecretiv
     * @return
     */
    public static String decrypt(String sSrc, String sKey, String datasecretiv) {
        try {
            // 判断 Key 是否正确
            if (sKey == null) {
                log.error("Key 为空 null");
                return null;
            }
            // 判断 Key 是否为 16 位
            if (sKey.length() != 16) {
                log.error("Key 长度不是 16 位");
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(datasecretiv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);//先用 base64 解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "UTF-8");
                return originalString;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 特殊字符转义
     * @param str
     * @return
     */
    public static String specialCharEscape(String str) {
        str = str.replaceAll(" ", "%20");
        str = str.replaceAll("\"", "%22");
        str = str.replaceAll("\\#", "%23");
        str = str.replaceAll("\\%", "%25");
        str = str.replaceAll("\\&", "%26");
        str = str.replaceAll("\\(", "%28");
        str = str.replaceAll("\\)", "%29");
        str = str.replaceAll("\\+", "%2B");
        str = str.replaceAll("\\,", "%2C");
        str = str.replaceAll("\\/", "%2F");
        str = str.replaceAll("\\:", "%3A");
        str = str.replaceAll("\\;", "%3B");
        str = str.replaceAll("\\<", "%3C");
        str = str.replaceAll("\\=", "%3D");
        return str;
    }
}