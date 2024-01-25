import { createApp } from 'vue';
import axios from 'axios';

const app = createApp({});
app.config.globalProperties.$axios = axios.create({
  baseURL: 'http://localhost:8081/api/v1', // Adjust the base URL according to your API
});

export default app;
