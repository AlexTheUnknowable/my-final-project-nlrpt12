<template>
  <div id="custom-app">
    <header>
      <router-link v-bind:to="{ name: 'home' }" id="logo">
        <img src="/img/pokeball-icon.png" alt="Pokeball icon" />
        <h1 id="title">Card Trader</h1>
      </router-link>
      <nav v-if="this.$store.state.token">
        <router-link class="navbtn" v-bind:to="{ name: 'store' }">Store</router-link>
        <router-link class="navbtn" v-bind:to="{ name: 'myCards' }">My cards</router-link>
        <router-link class="navbtn" v-bind:to="{ name: 'logout' }">Log out</router-link>
      </nav>
      <nav v-else>
        <router-link class="navbtn" v-bind:to="{ name: 'login' }">Log in</router-link>
        <router-link class="navbtn" v-bind:to="{ name: 'register' }">Register</router-link>
      </nav>
    </header>
    <main>
      <router-view />
    </main>
    <footer>This website is not affiliated with The Pokemon Company or Game Freak.</footer>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#custom-app {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto 1fr auto;
  grid-template-areas:
    "header"
    "main"
    "footer";
  gap: 5px;
  padding: 5px;
  height: 98vh;
}

main,
header {
  /* border-radius: 5px; */
  padding: 5px;
  margin: 8px;
}

header {
  grid-area: header;
  display: flex;
  background-color: lightgray;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;
  text-decoration: none;
}

#logo {
  display: flex;
  align-items: center;
  text-decoration: none;
  color: black;
}

#logo img {
  max-width: 5em;
  height: auto;
}

#logo h1 {
  margin: 10px;
  font-size: 30px;
  color: black;
}

#logo:hover {
  text-decoration: underline;
}

nav {
  display: flex;
}

.navbtn {
  background-color: lightblue;
  width: 110px;
  height: 50px;
  color: black;
  text-align: center;
  padding: 10px;
  margin: 10px;
  border: 2px solid rgb(59, 59, 59);
  border-radius: 3px;
  text-decoration: none;
  font-size: 20px;
}

.navbtn:visited,
.navbtn:visited p {
  color: black;
}

.navbtn:hover {
  background-color: rgb(151, 210, 231);
  text-decoration: underline;
}

main {
  grid-area: main;
}

footer {
  background-color: lightgray;
  grid-area: footer;
}

h2 {
  padding-bottom: 5px;
}

.cards{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.card {
  margin: 20px 50px;
}

button:active {
  -webkit-box-shadow: inset 0px 0px 5px #c1c1c1;
  -moz-box-shadow: inset 0px 0px 5px #c1c1c1;
  box-shadow: inset 0px 0px 5px #c1c1c1;
  outline: none;
}

form {
  max-width: 500px;
  margin: 2rem auto;
  padding: 2rem;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  font-family: Arial, sans-serif;
}

form label {
  font-size: 1rem;
  color: #333;
  margin-bottom: 0.5rem;
  display: block;
}

form input[type="text"],
form input[type="password"],
form input[type="number"],
form select,
form textarea {
  width: 100%;
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #fff;
  transition: border-color 0.3s ease;
  margin-bottom: 1rem;
}

form input[type="text"]:focus,
form input[type="password"]:focus,
form input[type="number"]:focus,
form select:focus,
form textarea:focus {
  border-color: lightsteelblue;
  outline: none;
}

@media only screen and (max-width: 740px) {
  header {
    grid-area: header;
    display: flex;
    flex-direction: column;
  }
}
</style>