# tomcat正常启动后，访问不了localhost:8080

## 原因

启动容器的脚本没有读写权限

```
➜  bin ls -al | grep startup.sh
-rwxr-x---@  1 jianglei  staff    1904 12  5  2016 startup.sh
```

## 解决办法

```
sudo ./startup.sh
```

这样启动就正常显示页面了

![](/assets/1524208167662.png)

