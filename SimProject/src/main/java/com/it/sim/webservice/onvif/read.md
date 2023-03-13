# 经常超时,异常, 命名冲突
wsimport -encoding utf-8 -s ../../../../../ -p com.it.sim.webservice.onvif.client2 -extension -Xnocompile  E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\devicemgmt.wsdl

# 偶尔成功
wsimport -encoding utf-8 -s ../../../../../ -extension -Xnocompile  E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\devicemgmt.wsdl

#cd $project_home/src/main/java (效果最好)
WSDL2Java -encoding utf-8 -autoNameResolution -p com.it.sim.webservice.onvif.client E:\workspace\JavaSpace\TemplateBoot\SimProject\src\main\java\com\it\sim\webservice\onvif\devicemgmt.wsdl

wsimport:
    https://www.iteye.com/blog/mhsjlove-1838339
    -d <directory>	指定.class文件的输出目录
    -s <directory>	指定源代码存放目录
    -verbose
    -keep	保留源文件
    -p <pkg>	指定包名
    -encoding <encoding>	指定编码格式，例如UTF-8
    -Xnocompile	不编译生成的源码
    -Xdebug	显示DEBUG信息
    -quiet	静默执行该命令，不在屏幕输出信息
