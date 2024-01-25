# 经常超时,异常, 命名冲突
wsimport -encoding utf-8 -s ../../../../ -p com.it.sim.webservice.onvif.client2 -extension -Xnocompile  D:\workspace\JavaSpace\TemplateBoot\TestWebService\src\main\java\com\it\webservice\onvif\devicemgmt.wsdl

# 偶尔成功
wsimport -encoding utf-8 -s ../../../../ -extension -Xnocompile  D:\workspace\JavaSpace\TemplateBoot\TestWebService\src\main\java\com\it\webservice\onvif\devicemgmt.wsdl

#cd $project_home/src/main/java (效果最好)
D:\dev\apache-cxf-3.5.4\bin\WSDL2Java -encoding utf-8 -autoNameResolution -p com.it.webservice.onvif.client D:\workspace\JavaSpace\TemplateBoot\TestWebService\src\main\java\com\it\webservice\onvif\devicemgmt.wsdl
