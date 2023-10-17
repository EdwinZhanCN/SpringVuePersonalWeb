# Setup Nginx
[Nginx(engine-x)](https://nginx.org/en/) is a popular open-source software used for web serving, reverse proxying, caching, load balancing, media streaming, and more.

In this article, we will continue our journey to the personal website.

## Get start with Linux system
On this system, we don't have any **GUI** (Graphic User Interface), we only use codes and commands to do anything.

Go to **Terminal**, change your identity into root user by use command:
```bash
sudo -i
```
Then your username will change to **root**@hostname

Use following command to update your software-package-list, we  do this before we install anything.
```bash
sudo apt update
```
Then, intall Nginx
```bash
sudo apt install nginx
```
And then, start Nginx service
```bash
sudo systemctl start nginx
```
Check the status of Nginx service
```bash
sudo systemctl status nginx
```
If you get this information, which means your Nginx service start successfully:
```bash
● nginx.service - A high performance web server and a reverse proxy server
     Loaded: loaded (/lib/systemd/system/nginx.service; enabled; vendor preset: enabled)
     Active: active (running) since Mon 2023-10-16 19:09:25 EDT; 3h 2min ago
       Docs: man:nginx(8)
   Main PID: 1112 (nginx)
      Tasks: 3 (limit: 2185)
     Memory: 5.4M
        CPU: 21ms
     CGroup: /system.slice/nginx.service
             ├─1112 "nginx: master process /usr/sbin/nginx -g daemon on; master_process on;"
             ├─1114 "nginx: worker process" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" ""
             └─1115 "nginx: worker process" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" "" ""

Oct 16 19:09:25 ubuntu-linux-22-04-02-desktop systemd[1]: Starting A high performance web server and a reverse proxy server...
Oct 16 19:09:25 ubuntu-linux-22-04-02-desktop systemd[1]: Started A high performance web server and a reverse proxy server.
```
**Well Down!** We will set our domain name in next article