import{_ as s,o as n,c as a,Q as e}from"./chunks/framework.7ed72bc6.js";const l="/assets/ssl-seller.9c9100b2.png",o="/assets/search-ssl.8fa13f15.png",p="/assets/ssl-drag.dac3e140.png",g=JSON.parse('{"title":"Setup SSL and Https","description":"","frontmatter":{},"headers":[],"relativePath":"SSL-Certificate-Setup.md","filePath":"SSL-Certificate-Setup.md"}'),t={name:"SSL-Certificate-Setup.md"},c=e('<h1 id="setup-ssl-and-https" tabindex="-1">Setup SSL and Https <a class="header-anchor" href="#setup-ssl-and-https" aria-label="Permalink to &quot;Setup SSL and Https&quot;">​</a></h1><p><strong>HTTPS incorporates the security provided by SSL/TLS, which encrypts the data transferred between a web browser and a web server to ensure it can&#39;t be intercepted or tampered with by third parties.</strong> Generally, If you don&#39;t want your Website to be &quot;Not Secure&quot;, you need this.</p><h2 id="get-a-ssl-certificate" tabindex="-1">Get a SSL Certificate <a class="header-anchor" href="#get-a-ssl-certificate" aria-label="Permalink to &quot;Get a SSL Certificate&quot;">​</a></h2><p>Similar to a domain name, you need an SSL Certificate from sellers, and you need a <strong>management station</strong> to handle it. An SSL Certificate should be bound to your domain name. <img src="'+l+'"></p><p>After you obtain a SSL certificate, you need to download your certificate. Since we are using Nginx, there are two files: one with a .pem extension and another with a .key extension.<strong>(pem/key)</strong></p><h2 id="setup-nginx-service" tabindex="-1">Setup Nginx Service <a class="header-anchor" href="#setup-nginx-service" aria-label="Permalink to &quot;Setup Nginx Service&quot;">​</a></h2><p>OK, now you should have <strong>two files</strong> related to your SSL certificate, which is awesome. Next, we need to go back to <strong>VSCode</strong> and set up our <strong>Nginx service.</strong></p><div class="tip custom-block"><p class="custom-block-title">TIP</p><p>Remember, using <code>sudo -i</code> to switch to the root user can make your life easier!</p></div><p>Now, we need to upload our <code>.pem</code> and <code>.key</code> files to our VM. Click the <strong>Open... icon</strong> on the welcome page of VSCode or go to <strong>File-&gt;Open Folder...</strong> on the top of the screen:</p><p>Then search <code>/etc/ssl/</code>, click <code>OK</code>. <img src="'+o+'"></p><p>Now you can see a <strong>File directory system</strong> is shown on the left sidebar, so you can simply <strong>drag your key/pem files into the <em>ssl</em> directory</strong>. That&#39;s reason why I choose VSCode to connect our VM, it is simple and readable. <img src="'+p+`"></p><p>After you finish uploading the files, go to our sites-available default file:</p><div class="language-bash vp-adaptive-theme"><button title="Copy Code" class="copy"></button><span class="lang">bash</span><pre class="shiki github-dark vp-code-dark"><code><span class="line"><span style="color:#B392F0;">nano</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">/etc/nginx/sites-available/default</span></span></code></pre><pre class="shiki github-light vp-code-light"><code><span class="line"><span style="color:#6F42C1;">nano</span><span style="color:#24292E;"> </span><span style="color:#032F62;">/etc/nginx/sites-available/default</span></span></code></pre></div><p>Check your content and copy the code, you should have a similar layout with mine, <strong>except the server_name and the path to your ssl_certificate.:</strong></p><div class="language-bash vp-adaptive-theme"><button title="Copy Code" class="copy"></button><span class="lang">bash</span><pre class="shiki github-dark vp-code-dark"><code><span class="line"><span style="color:#B392F0;">server</span><span style="color:#E1E4E8;">{</span></span>
<span class="line"><span style="color:#E1E4E8;">        </span><span style="color:#B392F0;">listen</span><span style="color:#E1E4E8;"> </span><span style="color:#79B8FF;">80</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">        </span><span style="color:#B392F0;">listen</span><span style="color:#E1E4E8;"> [::]:80;</span></span>
<span class="line"><span style="color:#E1E4E8;">        </span><span style="color:#B392F0;">server_name</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">edwinzhan.online</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">www.edwinzhan.online</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#E1E4E8;">        </span><span style="color:#B392F0;">rewrite</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">^</span><span style="color:#E1E4E8;">(</span><span style="color:#79B8FF;">.</span><span style="color:#E1E4E8;">*)$ </span><span style="color:#9ECBFF;">https://</span><span style="color:#E1E4E8;">$host</span><span style="color:#FFAB70;">$1</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">permanent</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#E1E4E8;">        </span><span style="color:#B392F0;">server</span><span style="color:#E1E4E8;">{</span></span>
<span class="line"><span style="color:#E1E4E8;">                </span><span style="color:#B392F0;">listen</span><span style="color:#E1E4E8;"> </span><span style="color:#79B8FF;">443</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">ssl</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">defualt_server</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">                        </span><span style="color:#B392F0;">listen</span><span style="color:#E1E4E8;"> [::]:443 ssl default_server;</span></span>
<span class="line"><span style="color:#E1E4E8;">                </span><span style="color:#B392F0;">server_name</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">ewinzhan.online</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">www.edwinzhan.online</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">                        </span><span style="color:#B392F0;">ssl_certificate</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">/etc/ssl/edwinzahn.online.pem</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">                        </span><span style="color:#B392F0;">ssl_certificate_key</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">/etc/ssl/edwinzhan.online.key</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#E1E4E8;">                        </span><span style="color:#B392F0;">ssl_session_timeout</span><span style="color:#E1E4E8;"> </span><span style="color:#79B8FF;">5</span><span style="color:#9ECBFF;">m</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">                </span><span style="color:#B392F0;">ssl_protocols</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">TLSv1</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">TLSv1.1</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">TLSv1.2</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">                        </span><span style="color:#B392F0;">ssl_cipher</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#E1E4E8;">                        </span><span style="color:#B392F0;">ssl_prefer_server_ciphers</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">on</span></span>
<span class="line"></span>
<span class="line"></span>
<span class="line"><span style="color:#E1E4E8;">        </span><span style="color:#B392F0;">location</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">/{</span></span>
<span class="line"><span style="color:#E1E4E8;">                </span><span style="color:#B392F0;">root</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">/var/www/web</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">                </span><span style="color:#B392F0;">index</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">/main/main.html</span><span style="color:#E1E4E8;">;</span></span>
<span class="line"><span style="color:#E1E4E8;">        }</span></span>
<span class="line"></span>
<span class="line"><span style="color:#E1E4E8;">}</span></span></code></pre><pre class="shiki github-light vp-code-light"><code><span class="line"><span style="color:#6F42C1;">server</span><span style="color:#24292E;">{</span></span>
<span class="line"><span style="color:#24292E;">        </span><span style="color:#6F42C1;">listen</span><span style="color:#24292E;"> </span><span style="color:#005CC5;">80</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">        </span><span style="color:#6F42C1;">listen</span><span style="color:#24292E;"> [::]:80;</span></span>
<span class="line"><span style="color:#24292E;">        </span><span style="color:#6F42C1;">server_name</span><span style="color:#24292E;"> </span><span style="color:#032F62;">edwinzhan.online</span><span style="color:#24292E;"> </span><span style="color:#032F62;">www.edwinzhan.online</span><span style="color:#24292E;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#24292E;">        </span><span style="color:#6F42C1;">rewrite</span><span style="color:#24292E;"> </span><span style="color:#032F62;">^</span><span style="color:#24292E;">(</span><span style="color:#005CC5;">.</span><span style="color:#24292E;">*)$ </span><span style="color:#032F62;">https://</span><span style="color:#24292E;">$host</span><span style="color:#E36209;">$1</span><span style="color:#24292E;"> </span><span style="color:#032F62;">permanent</span><span style="color:#24292E;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#24292E;">        </span><span style="color:#6F42C1;">server</span><span style="color:#24292E;">{</span></span>
<span class="line"><span style="color:#24292E;">                </span><span style="color:#6F42C1;">listen</span><span style="color:#24292E;"> </span><span style="color:#005CC5;">443</span><span style="color:#24292E;"> </span><span style="color:#032F62;">ssl</span><span style="color:#24292E;"> </span><span style="color:#032F62;">defualt_server</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">                        </span><span style="color:#6F42C1;">listen</span><span style="color:#24292E;"> [::]:443 ssl default_server;</span></span>
<span class="line"><span style="color:#24292E;">                </span><span style="color:#6F42C1;">server_name</span><span style="color:#24292E;"> </span><span style="color:#032F62;">ewinzhan.online</span><span style="color:#24292E;"> </span><span style="color:#032F62;">www.edwinzhan.online</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">                        </span><span style="color:#6F42C1;">ssl_certificate</span><span style="color:#24292E;"> </span><span style="color:#032F62;">/etc/ssl/edwinzahn.online.pem</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">                        </span><span style="color:#6F42C1;">ssl_certificate_key</span><span style="color:#24292E;"> </span><span style="color:#032F62;">/etc/ssl/edwinzhan.online.key</span><span style="color:#24292E;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#24292E;">                        </span><span style="color:#6F42C1;">ssl_session_timeout</span><span style="color:#24292E;"> </span><span style="color:#005CC5;">5</span><span style="color:#032F62;">m</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">                </span><span style="color:#6F42C1;">ssl_protocols</span><span style="color:#24292E;"> </span><span style="color:#032F62;">TLSv1</span><span style="color:#24292E;"> </span><span style="color:#032F62;">TLSv1.1</span><span style="color:#24292E;"> </span><span style="color:#032F62;">TLSv1.2</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">                        </span><span style="color:#6F42C1;">ssl_cipher</span><span style="color:#24292E;"> </span><span style="color:#032F62;">ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE</span><span style="color:#24292E;">;</span></span>
<span class="line"></span>
<span class="line"><span style="color:#24292E;">                        </span><span style="color:#6F42C1;">ssl_prefer_server_ciphers</span><span style="color:#24292E;"> </span><span style="color:#032F62;">on</span></span>
<span class="line"></span>
<span class="line"></span>
<span class="line"><span style="color:#24292E;">        </span><span style="color:#6F42C1;">location</span><span style="color:#24292E;"> </span><span style="color:#032F62;">/{</span></span>
<span class="line"><span style="color:#24292E;">                </span><span style="color:#6F42C1;">root</span><span style="color:#24292E;"> </span><span style="color:#032F62;">/var/www/web</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">                </span><span style="color:#6F42C1;">index</span><span style="color:#24292E;"> </span><span style="color:#032F62;">/main/main.html</span><span style="color:#24292E;">;</span></span>
<span class="line"><span style="color:#24292E;">        }</span></span>
<span class="line"></span>
<span class="line"><span style="color:#24292E;">}</span></span></code></pre></div><p>Restart Nginx:</p><div class="language-bash vp-adaptive-theme"><button title="Copy Code" class="copy"></button><span class="lang">bash</span><pre class="shiki github-dark vp-code-dark"><code><span class="line"><span style="color:#B392F0;">sudo</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">systemctl</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">restart</span><span style="color:#E1E4E8;"> </span><span style="color:#9ECBFF;">nginx</span></span></code></pre><pre class="shiki github-light vp-code-light"><code><span class="line"><span style="color:#6F42C1;">sudo</span><span style="color:#24292E;"> </span><span style="color:#032F62;">systemctl</span><span style="color:#24292E;"> </span><span style="color:#032F62;">restart</span><span style="color:#24292E;"> </span><span style="color:#032F62;">nginx</span></span></code></pre></div><p>Now you successfully setup your SSL certificate!</p><p>I will explain the <code>location /</code> part in next article.</p>`,19),r=[c];function i(E,y,d,F,h,u){return n(),a("div",null,r)}const m=s(t,[["render",i]]);export{g as __pageData,m as default};