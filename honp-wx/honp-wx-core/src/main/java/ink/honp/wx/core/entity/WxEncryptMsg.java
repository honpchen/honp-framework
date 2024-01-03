package ink.honp.wx.core.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/03 16:11
 */
@Data
@Accessors(chain = true)
public class WxEncryptMsg {

    private String toUserName;

    private String encrypt;
}
