package ink.honp.wx.miniapp.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/03 18:19
 */
@Data
@Accessors(chain = true)
public class WxaQrcodeUnlimitedRequest extends WxaQrcodeRequest {

    /**
     * 默认是主页，页面 page，例如 pages/index/index，根路径前不要填加 /，不能携带参数（参数请放在scene字段里），
     * 如果不填写这个字段，默认跳主页面。scancode_time为系统保留参数，不允许配置
     */
    private String page;

    /**
     * 场景值，必填
     * <pre>
     *     最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
     *     其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     * </pre>
     */
    private String scene;

    /**
     * 默认是true，检查page 是否存在
     * <pre>
     *  true 时 page 必须是已经发布的小程序存在的页面（否则报错）；
     *  false 时允许小程序未发布或者 page 不存在， 但page 有数量上限（60000个）请勿滥用。
     * </pre>
     */
    @JsonProperty("check_path")
    private boolean checkPath = true;

}
