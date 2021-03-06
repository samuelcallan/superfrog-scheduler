import { createApp } from 'vue';
import App from './App.vue';
import router, { setupRouter } from '@/router';
import { setupPlugins } from './plugins';


const app = createApp(App);
  setupPlugins(app); // since router will use Pinia, we must set up Pinia first
  setupRouter(app);
  
  async function bootstrap(){
    await router.isReady(); // wait till router is ready before mounting
    app.mount('#app');
  }

  bootstrap();
  


