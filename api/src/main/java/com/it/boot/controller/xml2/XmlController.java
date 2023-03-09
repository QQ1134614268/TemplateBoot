package com.it.boot.controller.xml2;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import java.io.InputStream;

/**
 * Created by wl on 2021/6/18.
 */
@RequestMapping("/xml")
@RestController
public class XmlController {

    @RequestMapping(value = "/jacksonXmlRequest", consumes = MediaType.APPLICATION_XML_VALUE
            , produces = MediaType.APPLICATION_XML_VALUE)
    public Object jacksonXmlRequest(@RequestBody JacksonXmlBean jacksonXmlBean) {
        jacksonXmlBean.setId(jacksonXmlBean.getId() + 1);
        jacksonXmlBean.setName(jacksonXmlBean.getName() + "1");
        jacksonXmlBean.setNickName(jacksonXmlBean.getNickName() + "1");
        return jacksonXmlBean;
    }

    @RequestMapping(value = "/jaxbXmlRequest", consumes = MediaType.APPLICATION_XML_VALUE
            , produces = MediaType.APPLICATION_XML_VALUE)
    public void jaxbXmlRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream is = request.getInputStream();
        //注意传入的xml格式与JaxbXmlBean一致
        JAXBContext context = JAXBContext.newInstance(JaxbXmlBean.class);
        JaxbXmlBean jaxbXmlBean = (JaxbXmlBean) context.createUnmarshaller().unmarshal(is);
        jaxbXmlBean.setId(jaxbXmlBean.getId() + 1);
        jaxbXmlBean.setName(jaxbXmlBean.getName() + "1");
        jaxbXmlBean.setNickName(jaxbXmlBean.getNickName() + "1");
        response.setHeader("Content-type", MediaType.APPLICATION_XML_VALUE);
        context.createMarshaller().marshal(jaxbXmlBean, response.getWriter());
    }

}