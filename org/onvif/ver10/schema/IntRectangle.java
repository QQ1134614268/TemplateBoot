
package org.onvif.ver10.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Rectangle defined by lower left corner position and size. Units are pixel.
 *             
 * 
 * <p>IntRectangle complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IntRectangle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="x" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="y" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="width" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="height" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntRectangle")
public class IntRectangle {

    @XmlAttribute(name = "x", required = true)
    protected int x;
    @XmlAttribute(name = "y", required = true)
    protected int y;
    @XmlAttribute(name = "width", required = true)
    protected int width;
    @XmlAttribute(name = "height", required = true)
    protected int height;

    /**
     * ��ȡx���Ե�ֵ��
     * 
     */
    public int getX() {
        return x;
    }

    /**
     * ����x���Ե�ֵ��
     * 
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * ��ȡy���Ե�ֵ��
     * 
     */
    public int getY() {
        return y;
    }

    /**
     * ����y���Ե�ֵ��
     * 
     */
    public void setY(int value) {
        this.y = value;
    }

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
