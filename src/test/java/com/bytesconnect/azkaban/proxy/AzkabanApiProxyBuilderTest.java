package com.bytesconnect.azkaban.proxy;

import com.bytesconnect.azkaban.api.AzkabanApi;
import com.bytesconnect.azkaban.response.ExecuteFlowResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mason.Zhou on 2020/6/23
 */
public class AzkabanApiProxyBuilderTest {
    @Test
    public void builder() {
        AzkabanApi api = AzkabanApiProxyBuilder.create()
                .setUri("")
                .setUsername("")
                .setPassword("")
                .build();

        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("flowOverride[year_season]","202002"));

        ExecuteFlowResponse res = api.executeFlow("source-cosmolady-sandbox", "sync_allocation_order_distribution",paramList);
        System.out.println(res.getStatus());
        System.out.println(res.getExecid());


//        FetchExecFlowResponse response = api.fetchExecFlow("134");
//        System.out.println(response.getStatus());
//        System.out.println(response.getEndTime());
    }
}