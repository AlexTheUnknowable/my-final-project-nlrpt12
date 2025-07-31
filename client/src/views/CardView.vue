<template>
    <router-link class="home" v-bind:to="{ name: 'home' }">&lt; Home</router-link>
    <div class="card-container">
        <div class="card" v-bind:card="card">
            <img src="/img/pokeball-icon.png"/>
            <p id="name">{{ card.name }}</p>
            <p id="rarity">Rarity: {{ card.rarity }}</p>
            <button v-if="isAdmin" v-on:click="remove">Delete card</button>
        </div>
    </div>    
</template>
  
<script>
  import cardService from '../services/CardService';
  
  export default {
    data() {
      return {
        card: ''
      };
    },
    computed: {
      isAdmin() {
        return this.$store.state.user.role === "ROLE_ADMIN";
      }
    },
    methods: {
      remove() {
        if (confirm("Really delete this card?")) {
          cardService.delete(this.card.id).then((response) => {
            console.log("Card deleted");
            this.$router.push("/");
          });
        }
      }
    },
    created() {
      cardService.get(this.$route.params.cardId).then((response) => {
        this.card = response.data;
      });
    }
  }
</script>
  
<style scoped>

.home {
    text-decoration: none;
    color: black;
}

.home:visited {
    text-decoration: none;
}

.home:hover {
    text-decoration: underline;
}

.card-container {
    display: flex;
    justify-content: center;
}

.card {
    margin: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: lightgray;
}

.card img {
    margin: 15px;
    background-color: gray;
}

p {
    margin-left: 10px;
    margin-right: 10px;
}

#name {
    margin-top: 0;
    margin-bottom: 10px;
    font-size: 40px;
}

</style>