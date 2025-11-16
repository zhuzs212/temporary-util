package com.zzs.temporaryutil.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 签名采用 HMAC-MD5 算法，采用 MD5 作为散列函数，通过签名密钥（SigSecret）对整个请求主体进行加密，然后采用 MD5 信息摘要的方式形成新的密文，
 * 参数签名要求大写参数签名顺序按照消息体顺序拼接后执行。拼接顺序为 OperatorID、Data、TimeStamp、Seq。
 *
 * @author zhuzs
 * @date 2022/7/14 20:34
 */
public class HMacMD5Util {

    public static String getHmacMd5Str(String key, String data) {
        String result = "";
        try {
            byte[] keyByte = key.getBytes("UTF-8");
            byte[] dataByte = data.getBytes("UTF-8");
            byte[] hmacMd5Byte = getHmacMd5Bytes(keyByte, dataByte);
            StringBuffer md5StrBuff = new StringBuffer();
            for (int i = 0; i < hmacMd5Byte.length; i++) {
                if (Integer.toHexString(0xFF & hmacMd5Byte[i]).length() == 1)
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & hmacMd5Byte[i]));
                else md5StrBuff.append(Integer.toHexString(0xFF & hmacMd5Byte[i]));
            }
            result = md5StrBuff.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static byte[] getHmacMd5Bytes(byte[] key, byte[] data) throws NoSuchAlgorithmException {  /*                * HmacMd5 calculation formula: H(K XOR opad, H(K XOR ipad, text))                * HmacMd5 计算公式：H(K XOR opad, H(K XOR ipad, text))                * H 代表 hash 算法，本类中使用 MD5 算法，K 代表密钥，text 代表要加密的数据 ipad 为 0x36，opad 为 0x5C。                */
        int length = 64;
        byte[] ipad = new byte[length];
        byte[] opad = new byte[length];
        for (int i = 0; i < 64; i++) {
            ipad[i] = 0x36;
            opad[i] = 0x5C;
        }
        byte[] actualKey = key;
        // Actual key
        byte[] keyArr = new byte[length];
        // Key bytes of 64 bytes length
        /*
         * If key's length is longer than 64,then use hash to digest it and use
         * the result as actual key. 如果密钥长度，大于 64 字节，就使用哈希算法，计算其摘要，作为真正的密钥。
         */
        if (key.length > length) {
            actualKey = md5(key);
        }
        for (int i = 0; i < actualKey.length; i++) {
            keyArr[i] = actualKey[i];
        }               /*                * append zeros to K 如果密钥长度不足 64 字节，就使用 0x00 补齐到 64 字节。                */
        if (actualKey.length < length) {
            for (int i = actualKey.length; i < keyArr.length; i++) keyArr[i] = 0x00;
        }                /*                * calc K XOR ipad 使用密钥和 ipad 进行异或运算。                */
        byte[] kIpadXorResult = new byte[length];
        for (int i = 0; i < length; i++) {
            kIpadXorResult[i] = (byte) (keyArr[i] ^ ipad[i]);
        }                /*                * append "text" to the end of "K XOR ipad" 将待加密数据追加到 K XOR ipad 计算结果后面。                */
        byte[] firstAppendResult = new byte[kIpadXorResult.length + data.length];
        for (int i = 0; i < kIpadXorResult.length; i++) {
            firstAppendResult[i] = kIpadXorResult[i];
        }
        for (int i = 0; i < data.length; i++) {
            firstAppendResult[i + keyArr.length] = data[i];
        }                /*                * calc H(K XOR ipad, text) 使用哈希算法计算上面结果的摘要。                */
        byte[] firstHashResult = md5(firstAppendResult);                /*                * calc K XOR opad 使用密钥和 opad 进行异或运算。                */
        byte[] kOpadXorResult = new byte[length];
        for (int i = 0; i < length; i++) {
            kOpadXorResult[i] = (byte) (keyArr[i] ^ opad[i]);
        }                /*                * append "H(K XOR ipad, text)" to the end of "K XOR opad" 将 H(K XOR                * ipad, text)结果追加到 K XOR opad 结果后面                */
        byte[] secondAppendResult = new byte[kOpadXorResult.length + firstHashResult.length];
        for (int i = 0; i < kOpadXorResult.length; i++) {
            secondAppendResult[i] = kOpadXorResult[i];
        }
        for (int i = 0; i < firstHashResult.length; i++) {
            secondAppendResult[i + keyArr.length] = firstHashResult[i];
        }                /*                * H(K XOR opad, H(K XOR ipad, text)) 对上面的数据进行哈希运算。                */
        byte[] hmacMd5Bytes = md5(secondAppendResult);
        return hmacMd5Bytes;
    }

    private static byte[] md5(byte[] str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str);
        return md.digest();
    }

    public static void main(String[] args) {
        // 签名密钥
        String sigSecret = "yyyyyyyyyyyyyyyy";
        // 消息密钥，用于对所有接口中的 Data 信息进行加密
        String dataSecret = "DDDDDDD";
        // 消息密钥初始化向量，用户 AES 加密过程的混合加密。16 位字符
        String dataSecretIv = "XXXXXXXX";
        // 运营商标识
        String operatorId = "MA002TMQX";

        String data = "{'EquipAuthSeq':'MA002TMQX202004090925368255','ConnectorID':'MA01H3BQ1_1306060015204'}";
        String retData = QEncodeUtil.encrypt(data, dataSecret, dataSecretIv);
        String timeStamp = "20200409000000";
        String seq = "0001";
        String sig = getHmacMd5Str(sigSecret, operatorId + retData + timeStamp + seq);
        System.out.println("sig: " + sig);
    }
}
