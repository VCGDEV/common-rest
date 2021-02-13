package com.vcgdev.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import com.vcgdev.common.crypto.CryptoService;
import com.vcgdev.common.crypto.KeyFactoryProvider;

import org.junit.Test;

public class CryptoServiceTest {
    
    KeyFactoryProvider provider = new KeyFactoryProviderImpl("any-pwd", "some-sort-of-salt");
    CryptoService service = new CryptoService();
    IvParameterSpec spec = provider.generateIv();
    String specString = provider.ivSpecToString(spec);
    @Test
    public void givenString_whenEncrypt_thenSuccess()
        throws Exception { 
        KeyFactoryProvider provider = new KeyFactoryProviderImpl("any-pwd", "some-sort-of-salt");
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";
        SecretKey key = provider.generateKeys();
        IvParameterSpec ivParameterSpec = provider.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = service.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = service.decrypt(algorithm, cipherText, key, ivParameterSpec);
        assertEquals(input, plainText);
    }


    @Test
    public void givenIvString_whenEncrypt_thenSuccess()
        throws Exception { 
        KeyFactoryProvider provider = new KeyFactoryProviderImpl("any-pwd", "some-sort-of-salt");
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";
        SecretKey key = provider.generateKeys();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = service.encrypt(algorithm, input, key, provider.ivSpecFromString(specString));
        String plainText = service.decrypt(algorithm, cipherText, key, provider.ivSpecFromString(specString));
        assertEquals(input, plainText);
    }
}

class KeyFactoryProviderImpl extends KeyFactoryProvider {
    public KeyFactoryProviderImpl(String password, String salt) {
        this.password = password;
        this.salt = salt;
    }
}
