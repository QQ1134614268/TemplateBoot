package com.it.sim.xml.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

import java.util.List;

@Data
public class Envelope {
    @Data
    public static class Header {
        @JacksonXmlProperty(localName = "To")
        To to;
        @JacksonXmlProperty(localName = "Action")
        Action action;
    }

    @Data
    public static class To {
        @JacksonXmlProperty(localName = "mustUnderstand", isAttribute = true)
        String mustUnderstand;
        @JacksonXmlText
        String value;
    }

    @Data
    public static class Action {
        @JacksonXmlText
        String value;
    }

    @JacksonXmlProperty(localName = "Header")
    Header header;
    @JacksonXmlProperty(localName = "Body")
    Body body;

    @Data
    public static class Body {
        @JacksonXmlElementWrapper(localName = "Notify")
        @JacksonXmlProperty(localName = "NotificationMessage")
        List<NotificationMessage> notificationMessage;

        @Data
        public static class NotificationMessage {
            @Data
            public static class Topic {
                @JacksonXmlProperty(localName = "Dialect", isAttribute = true)
                String dialect;
                @JacksonXmlText
                String value;
            }

            @Data
            public static class Message {
                @Data
                public static class ItemList {
                    @Data
                    public static class SimpleItem {
                        @JacksonXmlProperty(localName = "Name",isAttribute = true)
                        String name;
                        @JacksonXmlProperty(localName = "Value",isAttribute = true)
                        String value;
                    }
                    @Data
                    public static class ElementItem {
                        @JacksonXmlProperty(localName = "Name",isAttribute = true)
                        String name;
                        @JacksonXmlProperty(localName = "Value",isAttribute = true)
                        String value;
                    }

                    @JacksonXmlElementWrapper(localName = "SimpleItem",useWrapping = false)
                    @JacksonXmlProperty(localName = "SimpleItem")
                    List<SimpleItem> simpleItem;

                    @JacksonXmlElementWrapper(localName = "ElementItem",useWrapping = false)
                    @JacksonXmlProperty(localName = "ElementItem")
                    List<ElementItem> elementItem;
                }

                @JacksonXmlProperty(localName = "UtcTime",isAttribute = true)
                String utcTime;

                @JacksonXmlProperty(localName = "PropertyOperation",isAttribute = true)
                String propertyOperation;

                @JacksonXmlProperty(localName = "Source")
                ItemList source;

                @JacksonXmlProperty(localName = "Data")
                ItemList data;

                @JacksonXmlProperty(localName = "Key")
                ItemList key;
            }

            @JacksonXmlProperty(localName = "Topic")
            Topic topic;

            @JacksonXmlElementWrapper(localName = "Message")
            @JacksonXmlProperty(localName = "Message")
            List<Message> message;
        }
    }
}
