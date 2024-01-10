package ink.honp.wx.core.util.crypt;

import ink.honp.core.constant.SymbolicConstant;
import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author jeffchen
 * date    2024/01/03 15:38
 */
@UtilityClass
public class SHA1 {

    /**
     * 串接arr参数，生成sha1 digest.
     * @param arr 参数数组
     */
    public static String gen(String... arr) {
        if (StringUtils.isAnyEmpty(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String a : arr) {
            sb.append(a);
        }
        return DigestUtils.sha1Hex(sb.toString());
    }

    /**
     * 用&串接arr参数，生成sha1 digest.
     * @param arr 参数数组
     */
    public static String genWithAmple(String... arr) {
        if (StringUtils.isAnyEmpty(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            sb.append(a);
            if (i != arr.length - 1) {
                sb.append(SymbolicConstant.AMPLE);
            }
        }
        return DigestUtils.sha1Hex(sb.toString());
    }
}
