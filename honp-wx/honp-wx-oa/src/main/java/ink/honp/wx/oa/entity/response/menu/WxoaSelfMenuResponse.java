package ink.honp.wx.oa.entity.response.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/09 15:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxoaSelfMenuResponse extends WxResponse {

    /**
     * 菜单是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_menu_open")
    private Integer isMenuOpen;
}
