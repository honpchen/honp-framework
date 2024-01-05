package ink.honp.wx.core.handler;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.core.entity.response.WxByteResponse;
import ink.honp.wx.core.entity.response.WxResponse;
import ink.honp.wx.core.exception.WxException;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2024/01/05 15:52
 */
public class WxByteResponseHandler implements WxResponseHandler<WxByteResponse> {
    @Override
    public WxByteResponse handle(Response response) throws WxException, IOException {
        WxByteResponse byteResponse = new WxByteResponse();

        ResponseBody responseBody = response.body();
        if (null == responseBody) {
            return byteResponse;
        }

        // 判断响应是否是 json 内容，若是则请求失败
        MediaType mediaType = responseBody.contentType();
        if (mediaType == null || !mediaType.toString().contains("json")) {
            byteResponse.setBytes(responseBody.bytes());
            return byteResponse;
        }

        WxResponse wechatResponse = JacksonUtil.toBean(responseBody.string(), WxResponse.class);
        if (Objects.isNull(wechatResponse)) {
            return byteResponse;
        }

        throw new WxException(wechatResponse.getErrcode(), wechatResponse.getErrmsg());
    }
}
