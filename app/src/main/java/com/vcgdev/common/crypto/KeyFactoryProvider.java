package com.vcgdev.common.crypto;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;

import com.vcgdev.common.exception.ErrorCode;
import com.vcgdev.common.exception.ServiceException;

@Slf4j
public abstract class KeyFactoryProvider {

    protected String password;
    protected String salt;
    
    public SecretKey generateKeys() throws ServiceException {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (Exception e) {
            log.error("Unable to create secret", e);
            throw new ServiceException(ErrorCode.INTERNAL);
        }
    }

    public IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String ivSpecToString(IvParameterSpec spec) {
        return Base64.getEncoder().encodeToString(spec.getIV());
    }

    public IvParameterSpec ivSpecFromString(String ivSpecString) {
        byte[] encoded = Base64.getDecoder()
            .decode(ivSpecString);
        return new IvParameterSpec(encoded);

    }
}
