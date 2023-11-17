参考: https://blog.csdn.net/qinxun2008081/article/details/131240103

D:\dev\jdk1.8.0_121\bin\keytool -genkey -alias myhttps -keyalg RSA -keysize 2048 -keystore D:\test.p12 -validity 365

genkey表示要创建一个新的密钥

alias表示keystore的别名

keyalg表示使用的加密算法是RSA

keysize表示密钥的长度

keystore表示生成密钥的存放位置

validity表示密钥的有效天数


