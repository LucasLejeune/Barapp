import { createRouter, createWebHistory } from 'vue-router'
import UserPage from '../components/UserPage.vue'
import PendingCommands from '../components/PendingCommands.vue'


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'Passer commande',
            component: UserPage
        },
        {
            path: '/commands',
            name: "Commandes",
            component: PendingCommands
        }
    ]
})

export default router