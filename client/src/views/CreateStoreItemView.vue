<template>
  <div>
    <form v-on:submit.prevent="submit">
      <h1>Sell this card?</h1>
      <div id="fields">
        <div class="card-item-component">
          <img src="/img/pokeball-icon.png"/>
          <p class="card-name">{{ cardItem.name }}</p>
        </div>
        <label for="price">Sell Price:</label>
        <input
          type="text"
          id="price"
          placeholder="Price"
          v-model="storeItem.price"
          required
        />
        <div><button type="submit">Submit</button></div>
      </div>
    </form>
  </div>
</template>

<script>
import storeService from "../services/StoreService.js";
import cardItemService from "../services/CardItemService.js";

export default {
  data() {
    return {
      storeItem: {
        cardItemId: '',
        price: ''
      },
      cardItem: {}
    };
  },
  methods: {
    submit() {
      storeService.putCardUpForSale(this.storeItem).then((response) => {
        this.$router.push("/cards/mycards");
      });
    }
  },
  created() {
    cardItemService.getByCardItemId(this.$route.params.cardItemId).then((response) => {
      this.cardItem = response.data;
    });
    this.storeItem.cardItemId = this.$route.params.cardItemId;
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
</style>