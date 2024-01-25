
package com.it.webservice.onvif.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>ArrayOfFileProgress complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFileProgress"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FileProgress" type="{http://www.onvif.org/ver10/schema}FileProgress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Extension" type="{http://www.onvif.org/ver10/schema}ArrayOfFileProgressExtension" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFileProgress", propOrder = {
    "fileProgress",
    "extension"
})
public class ArrayOfFileProgress {

    @XmlElement(name = "FileProgress")
    protected List<FileProgress> fileProgress;
    @XmlElement(name = "Extension")
    protected ArrayOfFileProgressExtension extension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the fileProgress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileProgress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileProgress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileProgress }
     * 
     * 
     */
    public List<FileProgress> getFileProgress() {
        if (fileProgress == null) {
            fileProgress = new ArrayList<FileProgress>();
        }
        return this.fileProgress;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFileProgressExtension }
     *     
     */
    public ArrayOfFileProgressExtension getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFileProgressExtension }
     *     
     */
    public void setExtension(ArrayOfFileProgressExtension value) {
        this.extension = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
