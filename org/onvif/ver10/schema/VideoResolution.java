
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>VideoResolution complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="VideoResolution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoResolution", propOrder = {
    "width",
    "height"
})
public class VideoResolution {

    @XmlElement(name = "Width")
    protected int width;
    @XmlElement(name = "Height")
    protected int height;

    /**
     * ��ȡwidth���Ե�ֵ��
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * ����width���Ե�ֵ��
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * ��ȡheight���Ե�ֵ��
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * ����height���Ե�ֵ��
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

}
