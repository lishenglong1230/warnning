package test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URLEncoder;

@SpringBootTest(classes = SellerApplication.class)
class DemoApplicationTests {
    public void execute() throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("accountSid").append("=").append(ChitConfig.ACCOUNT_SID);
        sb.append("&to").append("=").append("18222695630");
        sb.append("&param").append("=").append(URLEncoder.encode("","UTF-8"));
        sb.append("&templateid").append("=").append("1251");
		//sb.append("&smsContent").append("=").append( URLEncoder.encode("【秒嘀科技】您的验证码为123456，该验证码5分钟内有效。请勿泄漏于他人。","UTF-8"));
        String body = sb.toString() + ChitUtil.createCommonParam(ChitConfig.ACCOUNT_SID, ChitConfig.AUTH_TOKEN);
        String result = ChitUtil.post(ChitConfig.BASE_URL, body);
        System.out.println(result);

    }

    @Test
    void test() throws Exception {
        execute();

    }

}
