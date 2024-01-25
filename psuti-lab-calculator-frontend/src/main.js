import { createApp } from 'vue';
import App from './App.vue';
import axios from 'axios';

const app = createApp(App);

app.provide('$axios', axios.create({
    baseURL: 'http://localhost:8081/api/v1', // Adjust the base URL according to your API
  }));

app.mount('#app');