wsimport -s . E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\devicemgmt.wsdl

wsimport -s . E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\ptz.wsdl

wsimport -s . https://www.onvif.org/ver10/device/wsdl/devicemgmt.wsdl

wsimport -s . E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\onvif.xsd

wsimport -s . E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\EvalService.xml

wsimport -s . https://www.onvif.org/onvif/ver10/network/wsdl/remotediscovery.wsdl

wsimport -s . E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\devicemgmt.wsdl -extension -Xnocompile
