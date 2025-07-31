<template>
  <router-link v-bind:to="{ name: 'card', params: { cardId: card.id } }" class="card-component">
    <img src="/img/pokeball-icon.png"/>
    <p>{{ card.name }}</p>
  </router-link>
</template>

<script>
export default {
  props: ['card']
}
</script>

<style scoped>
.card-component {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: lightgray;
    text-decoration: none;
    color: black;
}

.card-component img {
    margin: 15px;
    background-color: gray;
    width: 250px;
    height: auto;
}

p {
    margin-top: 0;
    font-size: 25px;
}

.card-component:visited {
    text-decoration: none;
    color: black;
}
</style>