## 模块
``` lua
whp-cloud
├── whp-ui -- 前端工程[8000]
├── whp-auth -- 授权服务提供[3000]
├── whp-common -- 系统公共模块 
├    ├── whp-common-core -- 公共工具类核心包
├    ├── whp-common-cache -- 缓存
├    ├── whp-common-job -- 定时任务
├    ├── whp-common-log -- 日志服务
├    └── whp-common-security -- 安全工具类
├    └── whp-common-swagger -- Swagger Api文档生成
├    └── whp-common-transaction -- 分布式事务工具包
├── whp-config -- 配置中心[8888]
├── whp-eureka -- 服务注册与发现[8761]
├── whp-gateway -- Spring Cloud Gateway网关[9999]
├── whp-upms -- 通用用户权限管理模块
├    └── whp-upms-api -- 通用用户权限管理系统公共api模块
├    └── whp-upms-biz -- 通用用户权限管理系统业务处理模块[4000]
└── whp-visual  -- 图形化模块 
├    ├── whp-monitor -- Spring Boot Admin监控 [5001]
├    ├── whp-daemon -- 分布式调度中心[5002]
├    └── whp-code-gen -- 图形化代码生成[5003]
├    └── whp-tx-manager -- whpx分布式事务解决方案[5004]
├    └── whp-activiti -- 工作流模块[5005]
	 
```
