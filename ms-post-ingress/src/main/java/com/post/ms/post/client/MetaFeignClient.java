package com.post.ms.post.client;

import com.post.ms.post.configuration.FeignClientConfig;
import com.post.ms.post.client.external.MetaFeedResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "metaGraphClient",
        url = "${meta.api.base-url}",
        configuration = FeignClientConfig.class
)
public interface MetaFeignClient {

    @GetMapping("/me/feed")
    MetaFeedResponse getFeed(@RequestParam("fields") String fields,
                             @RequestParam("limit") int limit);
}
