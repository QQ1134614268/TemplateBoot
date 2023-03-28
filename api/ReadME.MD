java基础（十）捕获异常还是抛出异常
https://blogVO.csdn.net/miracle_8/article/details/78285940


1. 类自动生成表
2. 表映射成类
3. 查询投影
4. 自定义简单查询(lambda)
5. 逻辑删除
6. 自定义映射

#
1. mybatis + mybatis-plus + AcTable(自动建表)
2. jpa(太复杂) 自动建表,缓存, lambda(自定义), 连表查询, 投影

#  
1. 剥离JPA 或用于生产表 todo

# 
1. 开发工具-idea maven- git CiCd 面板, bug 需求
2. 微服务 rest
3. swagger
4. 框架-- mybatis-plus(支持lambda), mpj(投影), json字段映射(ListTypeHandel)
5. 大数据-存储(es|mongo),消费(kafka),查询
6. redis mysql
7. 定时 线程池 缓存
8. 表结构 需求
9. base dto 统计 时间范围 excel(poi) jwt druid
10. 单元测试
11. assert 状态码 上下文环境 mp
12. 代码检视
13. websocket
14. 服务注册与发现
15. 文件服务器 文件压缩
16. 服务器,时间钟 时区,镜像化(docker,k8s),服务器监控可视化
17. 网关
18. 适配的 团队,指导(教师 教与练习),获取, 预期的,结果的 过程的
19. 版本升级, 数据库字段,数据同步更新 取消字符串

#
背景, 要求(目标(从背景提取))问题, 方案 测试

###
背景, 要求(目标(从背景提取))问题, 方案 测试

###
环境:
    普通
         SZ SH BJ
    父子(类似下拉菜单 , 类似目录, 类似多张表合并)
         省市县
              县 根据市code(最好不要id)查找,
              列表查询
              树形结构
问题(目标):
    枚举表的结构,继承关系
    唯一的GroupCode
    每条的数据
    自动对应表
    根据code取值

    code 唯一吗? 代码中不好确定唯一

    使用id主键还是code?

方案:
    枚举类
    普通类
    理想约束下,code唯一, 宽松模式,code不唯一
    原始状态,每个分类一张表, 主键id 还是code ?? value String还是int?? 关联使用id还是code??
    使用groupCode 合并表, code会唯一吗 ??
    下拉表合并??

    转换代码,会不会太多?? 还需要吗, 自动生成, 唯一值控制

    遵从规则, ITree父子关联, 面向人(易于理解阅读), 或者转换设配ITree(ITree理想状态), 省市县如何关联, 测试

    父子,冗余设计,parentCode 与 parentId, code与id
#
研究: org.springframework.kafka.support.serializer.JsonDeserializer
