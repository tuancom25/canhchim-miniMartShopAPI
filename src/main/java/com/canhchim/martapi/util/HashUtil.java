/**
 * @author Duong Ngo Nam Anh
 */

package com.canhchim.martapi.util;

import org.apache.commons.codec.digest.DigestUtils;

public final class HashUtil {
    /**
     * Băm bằng hàm SHA256
     * @param input Xâu cần băm
     * @return
     */
    public static String sha256(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
