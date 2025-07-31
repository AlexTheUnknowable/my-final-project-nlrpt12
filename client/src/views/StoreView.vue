<template>
  <div class="top">
      <h2>This is the store</h2>
      <input name="search" type="text" placeholder="Search store..." v-model="searchTerm" v-on:keyup="searchStore"/>
    </div>
    <div class="storeItems">
      <store-item-component class="storeItem" v-for="storeItem in storeItemsToShow" v-bind:key="storeItem.storeItemId" v-bind:storeItem="storeItem"/>
    </div>
</template>

<script>
import storeService from "../services/StoreService.js";
import StoreItemComponent from "../components/StoreItemComponent.vue";

export default {
  components: {
    StoreItemComponent
  },
  data() {
    return {
      isLoading: false,
      storeItems: [],
      storeItemsToShow: [],
      searchTerm: ''
    };
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    }
  },
  methods: {
    searchStore() {
      this.storeItemsToShow = this.storeItems.filter((storeItem) => {
        return storeItem.name.toLowerCase().includes(this.searchTerm.toLowerCase());
      });
    }
  },
  created() {
      storeService.list().then((response) => {
        this.storeItems = response.data;
        this.storeItemsToShow = this.storeItems;
      });
    }
};
</script>

<style>
.storeItems{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.storeItem {
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