package ink.honp.wx.miniapp.service;

import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.miniapp.entity.request.user.WxaPhoneNumberGetRequest;
import ink.honp.wx.miniapp.service.impl.WxaUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/05 15:38
 */
@Slf4j
class WxaUserServiceTest extends WxaServiceTest {


    @Test
    void testGetPhoneNumberWithErrorCode() {
        WxaUserService userService = new WxaUserServiceImpl(getWxaClient());

        WxaPhoneNumberGetRequest phoneNumberGetRequest = new WxaPhoneNumberGetRequest()
                .setCode("asdasdas");

        WxException wxException = Assertions.assertThrows(WxException.class, () -> userService.getPhoneNumber(phoneNumberGetRequest));

        log.info("WXA get phone number [errcode:{}, errmsg:{}]", wxException.getCode(), wxException.getMessage());
    }


}
