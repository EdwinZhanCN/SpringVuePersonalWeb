import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
// @ts-ignore
export default defineConfig({
  title: "Welcome to my blog",
  description: "I will share my journey of computer science here.",
  base: '/',
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Blog', link: '/about' }
    ],

    sidebar: [
      {
        text: 'About this website',
        link: '/about',
      },
      {
        text: 'Personal Website Tutorial',
        collapsed: true,
        items: [
          { text: 'Introduction', link: '/personal-website-tutorial-about' },
          { text: 'Start with Azure', link: '/Start-with-Azure' },
          { text: 'Connect to Virtual Machine', link: '/Connect-to-Virtual-Machine' },
          { text: 'Setup Nginx', link: '/Nginx-Setup' },
          { text: 'Setup Domain name', link: '/Domain-name-setup' },
          { text: 'Setup SSL-Certificate (Optional)', link: '/SSL-Certificate-Setup'},
          { text: 'First HTML page!', link: '/First HTML page!'}
        ],
      },
    ],


    socialLinks: [
      { icon: 'github', link: 'https://github.com/EdwinZhanCN' }
    ]
  }
})
