# SendMail

### this is a monitor file and folder with java dev it can send the monitor path update and create file or folder

### 思路:
 1.递归遍历指定路径下面的所有文件文件夹
 
 2.获取文件和文件夹的create time and update time
 
 3.equals
 
 4.封装create file and update file in HashMap
 
 5.遍历HashMap，将KV拼接成HTML格式的字符串
 
 6.调用QQ邮箱的接口，发送邮件，发邮件之前需要对HashMap进行判空操作，不然会发很多空邮件
 
 7.使用Quartz定时任务，写cron 表达式，让监控系统半个小时扫描一次
