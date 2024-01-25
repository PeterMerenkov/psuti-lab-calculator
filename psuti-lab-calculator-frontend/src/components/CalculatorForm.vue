<template>
  <div>
    <div class="calculator">
      <h2>Формула сложения 2-х чисел</h2>
      <div class="input-container">
        <div class="input-group">
          <label for="x">X:</label>
          <input type="number" v-model="x" />
        </div>
        <div class="input-group">
          <label for="y">Y:</label>
          <input type="number" v-model="y" />
        </div>
      </div>
      <button @click="calculate">Вычислить</button>
      <div class="result-container">
        <strong>Результат:</strong> {{ calculateResult }}
      </div>
    </div>
    <div class="calculator">
      <h2>Формула для расчета среднего времени ожидания (W) в системе массового обслуживания (СМО) с использованием теории очередей</h2>
      <div class="input-container">
        <div class="input-group">
          <label for="arrivalRate">W:</label>
          <input type="number" v-model="arrivalRate" />
        </div>
        <div class="input-group">
          <label for="serviceRate">μ:</label>
          <input type="number" v-model="serviceRate" />
        </div>
        <div class="input-group">
          <label for="numberOfChannels">λ:</label>
          <input type="number" v-model="numberOfChannels" />
        </div>
      </div>
      <button @click="calculateWait">Вычислить</button>
      <div class="result-container">
        <strong>Результат:</strong> {{ calculateWaitTimeResult }}
      </div>
    </div>
  </div>
</template>

<script>
import { ref, inject } from 'vue';

export default {
  setup() {
    const axios = inject('$axios');

    const x = ref(0);
    const y = ref(0);
    const calculateResult = ref(null);
    const calculate = async () => {
      try {
        const response = await axios.get('/calculator/calculate', {
          params: { x: x.value, y: y.value },
        });
        calculateResult.value = response.data;
      } catch (error) {
        console.error('Ошибка:', error);
      }
    };

    const arrivalRate = ref(0);
    const serviceRate = ref(0);
    const numberOfChannels = ref(null);
    const calculateWaitTimeResult = ref(null);
    const calculateWait = async () => {
      try {
        const response = await axios.get('/calculator/calculate-wait-time', {
          params: { 
            arrivalRate: arrivalRate.value, 
            serviceRate: arrivalRate.value,
            numberOfChannels: arrivalRate.value,
            },
        });
        calculateWaitTimeResult.value = response.data;
      } catch (error) {
        console.error('Ошибка:', error);
      }
    };

    return {
      x,
      y,
      calculateResult,
      calculate,

      arrivalRate,
      serviceRate,
      numberOfChannels,
      calculateWaitTimeResult,
      calculateWait
    };
  },
};
</script>

<style scoped>
.calculator {
  max-width: 600px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  font-family: 'Arial', sans-serif; /* Use a sans-serif font */
}

.input-container {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}

.input-group {
  flex: 1;
  display: flex;
  align-items: center;
  margin-right: 10px; /* Добавлен горизонтальный отступ между .input-group */
}

label {
  margin-right: 10px;
}

input {
  flex: 1;
  width: 0;
  padding: 8px;
  box-sizing: border-box;
}

button {
  background-color: #007BFF;
  color: #fff;
  padding: 10px 15px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.result-container {
  margin-top: 15px;
  font-size: 18px;
}
</style>
