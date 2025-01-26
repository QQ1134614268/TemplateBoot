package com.it.jiangxin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.util.Map;

/**
 * <pre>
 * </pre>
 */
public class YmlUtils {

    public static Map<String, Object> toMap(String yaml) {
        Yaml yamlParser = new Yaml();
        //        Person person = yamlParser.loadAs(yaml, Person.class);
        return yamlParser.load(yaml);
    }

    public static String toYml(Object data) {

        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);  //块状格式

        Yaml yaml = new Yaml(options);

        return yaml.dump(data);
    }

}

