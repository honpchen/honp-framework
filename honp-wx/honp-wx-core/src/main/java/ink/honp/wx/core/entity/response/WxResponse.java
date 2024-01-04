package ink.honp.wx.core.entity.response;

import ink.honp.wx.core.constant.WxConstant;
import lombok.Data;

/**
 * 微信响应
 * @author jeffchen
 * date    2024/01/04 9:36
 */
@Data
public class WxResponse {

    private int errcode;

    private String errmsg;

    public boolean isSuccess() {
        return this.errcode == WxConstant.SUCCESS_CODE;
    }
}
