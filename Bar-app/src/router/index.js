import { createRouter, createWebHistory } from 'vue-router'
import UserPage from '../components/UserPage.vue'


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            component: UserPage
        }
    ]
})

export default router