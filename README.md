# azkaban-java-api
Java API for Azkaban

## 两种方式调用API
### 普通方式调用
无论在什么时候使用，只要使用代理构建器构建出AzkabanApi实例即可。如下代码所示：
```java
@Test
public void builder() {
    AzkabanApi apis = AzkabanApiProxyBuilder.create()
            .setUri("http://localhost:8666")
            .setUsername("azkaban")
            .setPassword("azkaban")
            .build();
}
```
### 整合Spring
通过AzkabanApiConfig类，创建Bean注册到Spring里，代码如下所示：
```java
package com.azkaban.config;


import AzkabanApi;
import AzkabanApiProxyBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置API，创建Bean，并注入Spring
 */
@Configuration
public class AzkabanApiConfig {
    @Value("${azkaban.url}")
    private String uri;

    @Value("${azkaban.username}")
    private String username;

    @Value("${azkaban.password}")
    private String password;

    @Bean
    public AzkabanApi azkabanApi() {
        return AzkabanApiProxyBuilder.create()
                .setUri(uri)
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
```

调用
```java
    @Autowired
    private AzkabanApi azkabanApi;
```


