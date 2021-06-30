import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPostRequest = new HttpPost("https://arachnotron.u4.singapore.swig.gy/api/v1/execute");
        HttpEntity httpEntity = new StringEntity("{\"data\":{\"clientData\":{\"conversationId\":\"p-bf.p-6958606.bhgfvqr_beqre_fhccbeg-655074-630559368578596\",\"data\":null,\"dataType\":null,\"entityId\":\"185004813023041\",\"nodeId\":\"8601601\",\"userId\":\"1403151\",\"versionId\":\"525\"},\"serverData\":{\"conversation\":null,\"node\":{},\"nodeID\":\"8601601\",\"versionID\":\"525\",\"workflowID\":\"100529\"}},\"stack\":[{\"actions\":[],\"contactConfigs\":null,\"lambdas\":[],\"rules\":[],\"signals\":[{\"name\":\"overlay-signal\",\"priority\":1}],\"templates\":[{\"name\":\"meta-data\",\"priority\":1},{\"name\":\"attachment\",\"priority\":2},{\"name\":\"salutation\",\"priority\":4},{\"name\":\"checking\",\"priority\":5},{\"name\":\"agent\",\"priority\":6},{\"name\":\"more-details\",\"priority\":3}]},{\"actions\":[],\"contactConfigs\":[],\"lambdas\":[],\"rules\":[],\"signals\":[],\"templates\":[]}]}");
        httpPostRequest.setEntity(httpEntity);
        CloseableHttpResponse httpResponse = client.execute(httpPostRequest);
        String responseContent = getHttpResponseBodyAsString(httpResponse.getEntity().getContent());
        System.out.println(responseContent);
    }

    private static String getHttpResponseBodyAsString(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = null;
            StringBuilder sb = new StringBuilder(1024);
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        }
    }
}


