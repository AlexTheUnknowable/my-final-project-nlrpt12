<template>
  <router-link class="home" v-bind:to="{ name: 'store' }">&lt; Store</router-link>
    <div class="store-item-container">
        <div class="store-item" v-bind:storeItem="storeItem">
            <img src="/img/pokeball-icon.png"/>
            <p id="name">{{ storeItem.name }}</p>
            <p id="price">Price: {{ storeItem.price }}</p>
            <p id="seller">Seller ID: {{ storeItem.userId }}</p>
        </div>
    </div>    
</template>

<script>
  import storeService from '../services/StoreService';
  
  export default {
    data() {
      return {
        storeItem: ''
      };
    },
    created() {
      storeService.get(this.$route.params.storeItemId).then((response) => {
        this.storeItem = response.data;
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

.store-item-container {
    display: flex;
    justify-content: center;
}

.store-item {
    margin: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: lightgray;
}

.store-item img {
    margin: 15px;
    background-color: gray;
}

p {
    margin-top: 0;
    font-size: 25px;
}

#name {
    margin-top: 0;
    margin-bottom: 17px;
    font-size: 40px;
}

</style>