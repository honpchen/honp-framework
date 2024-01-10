package ink.honp.wx.core.util.http.executor;

import ink.honp.core.http.request.MultipartFormRequest;
import ink.honp.core.util.CollectionUtil;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/10 16:18
 */
public class MediaUploadRequestExecutor extends SimpleRequestExecutor {

    private final OkHttpClient httpClient;

    public MediaUploadRequestExecutor(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Response execute(String url, Object data) throws IOException {
        if (!(data instanceof  File)) {
            throw new IllegalArgumentException("invalid file");
        }
        Map<String, File> uploadFile = CollectionUtil.newHashMap();
        uploadFile.put("media", (File) data);

        MultipartFormRequest multipartFormRequest = new MultipartFormRequest(url, null, uploadFile);
        return httpClient.newCall(multipartFormRequest.build()).execute();
    }
}
