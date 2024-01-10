package ink.honp.wx.core.util.http.convert;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.core.entity.response.WxResponse;
import ink.honp.wx.core.exception.WxException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2024/01/10 17:46
 */
public class SimpleResponseConvert extends AbstractResponseConverter<String> {

    @Override
    public String convert(Response source) throws WxException, IOException {
        ResponseBody body = source.body();
        if (Objects.isNull(body)) {
            return StringUtils.EMPTY;
        }

        String content = body.string();
        if (StringUtils.isBlank(content)) {
            return StringUtils.EMPTY;
        }

        WxResponse wxRep = JacksonUtil.toBean(content, WxResponse.class);
        if (Objects.isNull(wxRep)) {
            return StringUtils.EMPTY;
        }
        if (wxRep.isSuccess()) {
            return content;
        }
        throw new WxException(wxRep.getErrcode(), wxRep.getErrmsg());
    }
}
