<template>
  <div class="store-item-component">
    <img src="/img/pokeball-icon.png"/>
    <p>{{ storeItem.name }}</p>
    <p>Price: {{ storeItem.price }}</p>
    <button>Remove from store</button>
  </div>
</template>

<script>
export default {
  props: ['storeItem']
}
</script>

<style scoped>
.store-item-component {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: lightgray;
    text-decoration: none;
    color: black;
}

.store-item-component img {
    margin: 15px;
    background-color: gray;
    width: 250px;
    height: auto;
}

p {
    margin-top: 0;
    font-size: 25px;
}

.store-item-component:visited {
    text-decoration: none;
    color: black;
}
</style>