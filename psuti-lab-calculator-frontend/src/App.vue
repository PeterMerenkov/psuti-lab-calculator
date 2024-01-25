<template>
  <div id="app">
    <h1 class="main-heading">ПГУТИ</h1>
    <h2 class="sub-heading">Калькулятор для лабораторных работ</h2>
    <Calculator />
  </div>
</template>

<script>
import Calculator from './components/CalculatorForm.vue';

export default {
  name: 'App',
  components: {
    Calculator,
  },
};
</script>

<style>
.main-heading {
  color: #007BFF; /* Set the color as needed */
  font-size: 52px; /* Set the font size as needed */
  text-align: center; /* Center the text */
  font-weight: bold; /* Make the text bold */
  font-family: 'Arial', sans-serif; /* Use a sans-serif font */
  /* Add any other styles you want for the main heading */
}

.sub-heading {
  color: #333; /* Set the color as needed */
  font-size: 36px; /* Set the font size as needed */
  text-align: center; /* Center the text */
  font-family: 'Arial', sans-serif; /* Use a sans-serif font */
  /* Add any other styles you want for the subheading */
}
</style>
