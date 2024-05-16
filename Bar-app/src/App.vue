<script setup lang="ts">
// import HelloWorld from './components/HelloWorld.vue'
import { RouterView } from 'vue-router'
</script>


<template>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <RouterView />
</template>

<style scoped>
.logo {
  height: 200px;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
</style>
