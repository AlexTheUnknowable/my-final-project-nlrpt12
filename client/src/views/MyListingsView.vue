<template>
  <h2>These are your listings</h2>
  <h2>
    <router-link class="link" v-bind:to="{ name: 'store' }">&lt; Store</router-link>
  </h2>
    <div class="storeItems">
      <my-store-item-component class="storeItem" v-for="storeItem in myStoreItems" v-bind:key="storeItem.storeItemId" v-bind:storeItem="storeItem"/>
    </div>
</template>

<script>
import storeService from "../services/StoreService.js";
import MyStoreItemComponent from "../components/MyStoreItemComponent.vue";

export default {
  components: {
    MyStoreItemComponent
  },
  data() {
    return {
      isLoading: false,
      myStoreItems: []
    };
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    }
  },
  created() {
      storeService.getMyListings().then((response) => {
        this.myStoreItems = response.data;
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