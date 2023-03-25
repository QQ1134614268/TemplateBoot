package com.it.sim.xml.jacksonxml;

import com.it.sim.util.BuildDataUtil;
import org.junit.Test;

import java.util.Arrays;
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
}
