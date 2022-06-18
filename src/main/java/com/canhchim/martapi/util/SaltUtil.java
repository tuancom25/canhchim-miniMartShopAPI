/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.util;

import java.nio.charset.Charset;
import java.util.Random;

public final class SaltUtil {
    /**
     * Tạo xâu salt ngẫu nhiên.
     * @param length Độ dài của xâu salt
     * @return
     */
    public static String generate(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        String salt = new String(array, Charset.forName("UTF-8"));
        return salt;
    }
}
