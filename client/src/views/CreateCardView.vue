<template>
    <div>
      <form v-on:submit.prevent="create">
        <h1>Create new card:</h1>
        <div id="fields">
          <img src="/img/pokeball-icon.png"/>
          <label for="name">name:</label>
          <input
            type="text"
            id="name"
            placeholder="Name"
            v-model="card.name"
            required
          />
          <label for="rarity">Rarity:</label>
          <input
            type="text"
            id="rarity"
            placeholder="Rarity"
            v-model="card.rarity"
            required
          />
          <div><button type="submit">Submit</button></div>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import cardService from "../services/CardService.js";
  
  export default {
    data() {
      return {
        card: {
            name: '',
            rarity: ''
        }
      };
    },
    methods: {
      create() {
        cardService.add(this.card).then((response) => {
          this.$router.push("/");
        });
      }
    }
  }
  </script>
  
  <style scoped>

  </style>