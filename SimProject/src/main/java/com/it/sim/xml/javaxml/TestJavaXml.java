package com.it.sim.xml.javaxml;

import com.it.sim.util.BuildDataUtil;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @date 2023-03-14 17:11
 */
public class TestJavaXml {
    @Test
    public void testXml() throws JAXBException {
        UserXml userXml = BuildDataUtil.createData(UserXml.class);
        userXml.setXmlList1(Arrays.asList("1", "2"));
        userXml.setXmlList2(Arrays.asList("1", "2"));
        userXml.setUserAddrXmlList(
                Arrays.stream(new UserAddrXml[]{
                                BuildDataUtil.createData(UserAddrXml.class),
                                BuildDataUtil.createData(UserAddrXml.class)})
                        .collect(Collectors.toList()));
        userXml.setUserInfoXml(BuildDataUtil.createData(UserInfoXml.class));

        JAXBContext jaxbContext = JAXBContext.newInstance(UserXml.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.toString());
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(userXml, writer);
        System.out.println(writer);
    }
}
