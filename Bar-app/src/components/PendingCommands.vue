<template>
    <h1>Commandes en attente</h1>
    <li v-for="command in my_commands">
        <span class="h4">
            {{ command.table.name }}
        </span>
        <span v-for="commandCocktail in commandCocktails">
            <span v-if="commandCocktail.command_id.id === command.id">
                <br>
                - {{ commandCocktail.cocktail_id.name + '(' + commandCocktail.cocktail_size + ')' + " - " + commandCocktail.status }}
                <btn v-if="commandCocktail.status !== 'Terminée'" @click="nextStep(commandCocktail.id, commandCocktail.status)" class="btn btn-link">Passer à l'étape suivante</btn>
            </span>
        </span>
    </li>

    
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      cocktails: [],
      barmaker : [],
      cards : [],
      card : [],
      all_commands : [],
      my_commands : [],
      commandCocktails : [],
      test : [],
    };
  },
  async created() {
    document.title = "Commandes";
    const responseBarmaker = await axios.get('http://localhost:8080/barmakers/' + this.$route.query.barmaker);
    this.barmaker = responseBarmaker.data;
    const responseCard = await axios.get('http://localhost:8080/cards');
    this.cards = responseCard.data;
    this.card = this.cards.filter(card => card.barmaker.id === this.barmaker.id)[0]
    const responseCommands = await axios.get('http://localhost:8080/commands');
    this.commands = responseCommands.data
    this.my_commands = this.commands.filter(command => command.table.card.id === this.card.id && command.status != "Terminée")
    const responseCommandCocktails = await axios.get('http://localhost:8080/commandCocktail');
    this.commandCocktails = responseCommandCocktails.data
    this.my_commands.forEach(command => {
        let myCommandCocktails = this.commandCocktails.filter(commandCocktail => commandCocktail.command_id.id === command.id)
        this.test.push([myCommandCocktails])
        }
    )

  },
  methods: {
    nextStep(commandCocktailId, commandCocktailStatus) {
      const apiUrl = 'http://localhost:8080/commandCocktail/' + commandCocktailId;
      let data = {   
            status: "Préparation des ingrédients",
          };
      if (commandCocktailStatus === "En attente") {
          data = {   
            status: "Préparation des ingrédients",
          };
      }
      if (commandCocktailStatus === "Préparation des ingrédients") {
          data = {   
            status: "Assemblage",
          };
      }
      if (commandCocktailStatus === "Assemblage") {
          data = {   
            status: "Dressage",
          };
      }
      if (commandCocktailStatus === "Dressage") {
          data = {   
            status: "Terminée",
          };
      }

      axios.patch(apiUrl, data)
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error(error.response.data);
      });
      location.reload();
    },
  }
};
</script>

<style scoped>
.commandCocktails {
    padding-left: 10%;
}
</style>