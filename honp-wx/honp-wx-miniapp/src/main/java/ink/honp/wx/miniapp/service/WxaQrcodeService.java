package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.WxaQrcodeCreateRequest;
import ink.honp.wx.miniapp.entity.request.WxaQrcodeGetRequest;
import ink.honp.wx.miniapp.entity.request.WxaQrcodeUnlimitedRequest;

/**
 * @author jeffchen
 * date    2024/01/03 18:05
 */
public interface WxaQrcodeService extends WxaService {

    /**
     * 获取小程序二维码
     * <pre>
     *     该接口用于获取小程序码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
     * </pre>
     * @param qrcodeGetRequest 请求参数
     * @return 图片二进制
     */
    byte[] getQrcode(WxaQrcodeGetRequest qrcodeGetRequest);

    /**
     * 获取不限制的小程序码
     * <pre>
     *     该接口用于获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制
     * </pre>
     * @param qrcodeUnlimitedRequest 请求参数
     * @return 图片二进制
     */
    byte[] getUnlimitedQrcode(WxaQrcodeUnlimitedRequest qrcodeUnlimitedRequest);

    /**
     * 获取小程序二维码
     * <pre>
     *     获取小程序二维码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
     * </pre>
     * @param qrcodeCreateRequest 请求参数
     * @return 图片二进制
     */
    byte[] createQrcode(WxaQrcodeCreateRequest qrcodeCreateRequest);
}
