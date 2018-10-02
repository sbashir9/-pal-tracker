package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String s;
    private String s1;
    private String s2;
    private String s3;

    public EnvController(@Value("${PORT}") String s,@Value("${MEMORY_LIMIT}") String s1,@Value("${CF_INSTANCE_INDEX}") String s2,@Value("${CF_INSTANCE_ADDR}") String s3) {
        this.s = s;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {

        Map<String, String> env = new HashMap<>();

        env.put("PORT", s);
        env.put("MEMORY_LIMIT", s1);
        env.put("CF_INSTANCE_INDEX", s2);
        env.put("CF_INSTANCE_ADDR", s3);

        return env;
    }
}
