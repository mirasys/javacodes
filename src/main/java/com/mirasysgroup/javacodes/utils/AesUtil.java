package com.mirasysgroup.javacodes.utils;

import com.google.gson.Gson;
import com.mirasysgroup.javacodes.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

//import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;



public class AesUtil {
    public static final String ALGORITHM = "AES";
    public String encrypt(String plainText) throws Exception {
        try {
            Key key = new SecretKeySpec("CacServiceSecret".getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public String decrypt(String encryptedText) throws Exception {
        Key key = new SecretKeySpec("CacServiceSecret".getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
//        AesUtil aesUtil = new AesUtil();
//        String outcome = aesUtil.decrypt("Beba77xw1dF/cqlqu5HpAV4qVSo+PEGf/OiJaSLenjM=");
//        System.out.println(outcome);

        Response response1 = Response.builder()
                .code("200")
                .message("success")
                .httpStatusCode(HttpStatusCode.valueOf(200))
                .data("legumes")
                .description("done")
                .httpStatus(HttpStatus.OK)
                .build();

        Response response2 = Response.builder()
                .code("200")
                .message("failed")
                .httpStatusCode(HttpStatusCode.valueOf(200))
                .data(null)
                .description("pending")
                .httpStatus(HttpStatus.OK)
                .build();

        Map<String, String> results = compareObjects(response1,response2);


        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Gson gson = new Gson();
        String outcome = gson.toJson(results);
        System.out.println(outcome);

    }

    public static Map<String, String> compareObjects(Response response1, Response response2) throws IllegalAccessException {
        Map<String, String> differences = new HashMap<>();

        Field[] fields = response1.getClass().getDeclaredFields();
        //Field[] fields2 = response2.getClass().getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);

            Object value1 = field.get(response1);
            Object value2 = field.get(response2);

            if (value1 != null && value2 != null && !value1.equals(value2)){
               differences.put(field.getName(), (String) value1);
            } else if ((value1 == null && value2 != null) || (value1 != null && value2 == null)){
                differences.put(field.getName(), (String) value1);
            }
        }

        return differences;
    }

    //TODO:
}
