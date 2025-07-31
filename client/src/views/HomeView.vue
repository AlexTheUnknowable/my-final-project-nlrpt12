<template>
  <div class="home">
    <div class="top">
      <h2>This is the home page</h2>
      <button v-if="isAdmin" v-on:click="cardPage">Create a card</button>
      <input name="search" type="text" placeholder="Search cards..." v-model="searchTerm" v-on:keyup="searchCards"/>
    </div>
    <div class="cards">
      <card-component class="card" v-for="card in cardsToShow" v-bind:key="card.id" v-bind:card="card"/>
    </div>
  </div>
</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";
import CardComponent from "../components/CardComponent.vue";
import cardService from "../services/CardService.js";

export default {
  components: {
    LoadingSpinner,
    CardComponent,
  },
  data() {
    return {
      isLoading: false,
      cards: [],
      cardsToShow: [],
      searchTerm: ''
    };
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
    isAdmin() {
      return this.$store.state.user.role === "ROLE_ADMIN";
    }
  },
  methods: {
    searchCards() {
      this.cardsToShow = this.cards.filter((card) => {
        return card.name.toLowerCase().includes(this.searchTerm.toLowerCase());
      });
    },
    cardPage() {
      this.$router.push("/cards/create");
    }
  },
  created() {
      cardService.list().then((response) => {
        this.cards = response.data;
        this.cardsToShow = this.cards;
      });
    }
};
</script>

<style>
.top {
  display: flex;
  justify-content: space-between;
}

#spinner {
  color: green;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}
</style>