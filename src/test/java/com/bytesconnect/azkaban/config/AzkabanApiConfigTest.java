package com.bytesconnect.azkaban.config;

import com.bytesconnect.azkaban.Application;
import com.bytesconnect.azkaban.api.AzkabanApi;
import com.bytesconnect.azkaban.response.FetchExecFlowResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@ActiveProfiles(value = "test")
//@Transactional
//@Rollback
public class AzkabanApiConfigTest {
    @Autowired
    private AzkabanApi azkabanApi;

    @Test
    public void azkabanApi() {
        FetchExecFlowResponse fetchExecFlowResponse = azkabanApi.fetchExecFlow("111");
        System.out.println(fetchExecFlowResponse.getStatus());
    }
}