<template>
    <h1>La carte</h1>
    <li v-for="cocktail in card_cocktails" :key="cocktail.id">
      {{ cocktail.cocktail_id.name + '(' + cocktail.cocktail_size + ')' + ' - ' + cocktail.cocktail_price + '€'}} 
      <button v-if="pending_command.status === 'En attente'" @click="sendToCommand(cocktail.cocktail_id.id, cocktail.cocktail_size)" class="btn btn-link">Ajouter à la commande</button>
    </li>

    <h1>Ma commande</h1>
    <li v-for="command_cocktail in pending_command_cocktails">{{ command_cocktail.cocktail_id.name + '(' + command_cocktail.cocktail_size + ')' }}</li>
    <button v-if="pending_command.status === 'En attente'" @click="submitCommand()" class="btn btn-primary">Envoyer la commande</button>
    <span v-else>{{ pending_command.status }}</span>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      cocktails: [],
      table : [],
      card_id : 0,
      card_cocktails : [],
      command : [],
      pending_command : [],
      command_cocktails : [],
      pending_command_cocktails : [],
    };
  },
  async created() {
    document.title = "Passer commande";
    const responseTable = await axios.get('http://localhost:8080/tables/' + this.$route.query.table);
    this.table = responseTable.data;
    this.card_id = this.table.card.id;
    const responseCardCocktails = await axios.get('http://localhost:8080/cardCocktail');
    this.card_cocktails = responseCardCocktails.data;
    const responseCommand = await axios.get('http://localhost:8080/commands');
    this.commands = responseCommand.data;
    this.pending_command = this.commands.filter(command => command.table.id === this.table.id && (command.status === "En attente" || command.status === "En préparation"))
    if (this.pending_command.length === 0) {
      const apiUrl = 'http://localhost:8080/commands';

      const data = {
        tableId: this.table.id,
        sent_at: null,    
        status: "En attente"
      };

      axios.post(apiUrl, data)
      .then(response => {
        this.pending_command = response.data
      })
      .catch(error => {
        console.error(error.response.data);
      });
    }
    this.pending_command = this.pending_command[0]
    const responseCommandCocktails = await axios.get('http://localhost:8080/commandCocktail');
    this.command_cocktails = responseCommandCocktails.data;
    this.pending_command_cocktails = this.command_cocktails.filter(command_cocktail => command_cocktail.command_id.id === this.pending_command.id)
  
  },
  methods: {
    sendToCommand(cocktail_id, cocktail_size) {
      const apiUrl = 'http://localhost:8080/commandCocktail';
      const data = {
        command_id: this.pending_command.id,
        cocktail_id: cocktail_id,    
        status: "En attente",
        cocktail_size: cocktail_size
      };

      axios.post(apiUrl, data)
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error(error.response.data);
      });
      location.reload();
    },
    submitCommand() {
      const apiUrl = 'http://localhost:8080/commands/' + this.pending_command.id;
      const data = {
        status: "En préparation",
        sent_at: new Date().toISOString()
      };

      axios.patch(apiUrl, data)
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error(error.response.data);
      });
      location.reload();
    }
  }
};
</script>