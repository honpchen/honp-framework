package ink.honp.wx.core.executor;

import ink.honp.core.http.request.MultipartFormRequest;
import ink.honp.core.util.CollectionUtil;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/09 16:12
 */
public class WxUploadRequestExecutor implements WxRequestExecutor<Response>{

    private final OkHttpClient okHttpClient;

    public WxUploadRequestExecutor(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Response execute(String url, Object data) throws IOException {
        if (!(data instanceof File)) {
            throw new IOException("Invalid file");
        }
        
        Map<String, File> uploadFile = CollectionUtil.newHashMap();
        uploadFile.put("media", (File) data);

        MultipartFormRequest multipartFormRequest = new MultipartFormRequest(url, null, uploadFile);
        return okHttpClient.newCall(multipartFormRequest.build()).execute();
    }
}
