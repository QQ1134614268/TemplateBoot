package com.it.sim.xml.jacksonxml;

import com.alibaba.fastjson.JSON;
import com.it.sim.util.BuildDataUtil;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2023-03-10 15:20
 */
public class TestXml {

    @Test
    public void testXml() {
        UserXml userXml = BuildDataUtil.createData(UserXml.class);
        userXml.setUserAddressXmlList(Arrays.stream(new UserAddressXml[]{BuildDataUtil.createData(UserAddressXml.class), BuildDataUtil.createData(UserAddressXml.class)})
                .collect(Collectors.toList()));
        userXml.setUserInfoXml(BuildDataUtil.createData(UserInfoXml.class));
        userXml.setUserInfoXml3(BuildDataUtil.createData(UserInfoXml.class));

        String xml = XmlUtils.toXml(userXml);
        System.out.println(xml);
        System.out.println(XmlUtils.fromXml(xml, UserXml.class));
    }

    @Test
    public void testXml2() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Administrator\\Desktop\\out.xml.log"));
        List<String> lines2 = lines.stream().map(line -> {
            Envelope data = XmlUtils.fromXml(line, Envelope.class);
            return JSON.toJSONString(data);
        }).collect(Collectors.toList());
        Files.write(Paths.get("C:\\Users\\Administrator\\Desktop\\out.json.log"), lines2, StandardOpenOption.CREATE);
    }
}
