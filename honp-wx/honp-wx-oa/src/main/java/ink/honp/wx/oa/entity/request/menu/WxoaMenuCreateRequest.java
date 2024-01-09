package ink.honp.wx.oa.entity.request.menu;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/09 15:27
 */
@Data
@Accessors(chain = true)
public class WxoaMenuCreateRequest implements WxRequest {

    /**
     * 菜单按钮
     */
    private List<WxoaMenuButtonCreateRequest> button;

}
