<template>
  <div class="top">
      <h2>These are your cards</h2>
      <input name="search" type="text" placeholder="Search cards..." v-model="searchTerm" v-on:keyup="searchMyCards"/>
    </div>
  <div class="cardItems">
      <card-item-component class="cardItem" v-for="cardItem in cardItemsToShow" v-bind:key="cardItem.cardItemId" v-bind:cardItem="cardItem"/>
  </div>
</template>

<script>
import CardItemComponent from "../components/CardItemComponent.vue";
import cardItemService from "../services/CardItemService.js";

export default {
  components: {
    CardItemComponent
  },
  data() {
    return {
      isLoading: false,
      cardItems: [],
      cardItemsToShow: [],
      searchTerm: ''
    };
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    }
  },
  methods: {
    searchMyCards() {
      this.cardItemsToShow = this.cardItems.filter((cardItem) => {
        return cardItem.name.toLowerCase().includes(this.searchTerm.toLowerCase());
      });
    }
  },
  created() {
      cardItemService.list().then((response) => {
        this.cardItems = response.data;
        this.cardItemsToShow = this.cardItems;
      });
    }
};
</script>

<style>
.cardItems{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.cardItem {
  margin: 20px 50px;
}

.link,
.link:visited {
  text-decoration: none;
  color: blue;
}

.link:hover {
  text-decoration: underline;
}
</style>