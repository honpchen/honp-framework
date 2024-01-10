package ink.honp.wx.core.util.http.convert;

import ink.honp.wx.core.exception.WxException;

import java.io.IOException;

/**
 * 转换接口
 * @author jeffchen
 * date    2024/01/10 17:43
 */
public interface ResponseConverter <S, T> {

    T convert(S source) throws WxException, IOException;
}
