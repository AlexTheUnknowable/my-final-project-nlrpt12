<template>
  <div v-bind:to="{ name: 'card', params: { cardId: cardItem.cardItemId } }" class="card-item-component">
    <img src="/img/pokeball-icon.png"/>
    <p class="card-name">{{ cardItem.name }}</p>
    <section v-if="isForSale">
      <p>Up for sale</p>
      <button v-on:click="remove()">Remove from store</button>
    </section>
    <button v-else v-on:click="sell()">Sell</button>
  </div>
</template>

<script>
import storeService from '../services/StoreService';

export default {
  props: ['cardItem'],
  data() {
    return {
      isForSale: false
    };
  },
  methods: {
    sell() {
      this.$router.push({ name: 'storeItemCreation', params: { cardItemId: this.cardItem.cardItemId } });
    },
    remove() {
      if (confirm("Really remove this card from the store?")) {
        // get the store item id of the card item
        let storeItemId;
        storeService.getMyListings().then((response) => {
          let myStoreItems = response.data;
          for (const item of myStoreItems) {
            if (item.cardItemId == this.cardItem.cardItemId) {
              storeItemId = item.storeItemId;
              this.isForSale = false;
            }
          }
          if (storeItemId >= 0) {
            storeService.takeDownStoreItem(storeItemId).then((response) => {
              console.log("take it down babeyyyy")
            });
        } else {
          console.log("An error occurred: store item ID of card item not found.");
        }
        });
      }
    }
  },
  created() {
    storeService.getMyListings().then((response) => {
      let myStoreItems = response.data;
      for (const item of myStoreItems) {
        if (item.cardItemId == this.cardItem.cardItemId) {
          this.isForSale = true;
          return;
        }
        this.isForSale = false;
      }
    });
  }
}
</script>

<style scoped>
.card-item-component {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: lightgray;
    text-decoration: none;
    color: black;
    text-align: center;
}

.card-item-component img {
    margin: 15px;
    background-color: gray;
    width: 250px;
    height: auto;
}

.card-name {
    margin-top: 0;
    font-size: 25px;
}

.card-item-component:visited {
    text-decoration: none;
    color: black;
}
</style>