package com.vcgdev.common.crypto;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import com.vcgdev.common.exception.ErrorCode;
import com.vcgdev.common.exception.ServiceException;

public class CryptoService {

    public String encrypt(String algorithm, String input, SecretKey key,
        IvParameterSpec iv) throws ServiceException {
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] cipherText = cipher.doFinal(input.getBytes());
            return Base64.getEncoder()
                .encodeToString(cipherText);
        } catch(Exception e) {
            throw new ServiceException(ErrorCode.INTERNAL);
        }
    }

    public String decrypt(String algorithm, String cipherText, SecretKey key,
        IvParameterSpec iv) throws ServiceException {
        try {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
            .decode(cipherText));
        return new String(plainText);
        } catch (Exception e) {
            throw new ServiceException(ErrorCode.INTERNAL);
        }
    }
}
