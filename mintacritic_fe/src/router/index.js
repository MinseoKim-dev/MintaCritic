import Vue from 'vue';
import VueRouter from 'vue-router';
import MainPage from '@/components/MainPage';
import WriteReview from "@/components/WriteReview";
import ViewReview from "@/components/ViewReview";
import ModifyReview from "@/components/ModifyReview";
import RegisterPage from "@/components/RegisterPage";
import LoginPage from "@/components/LoginPage";
import RegisterAlbum from "@/components/RegisterAlbum";
import SearchAlbum from "@/components/SearchAlbum";
import LogoutPage from "@/components/LogoutPage";

Vue.use(VueRouter);

export default new VueRouter({
    mode:'history',
    routes: [{
        path: '/',
        redirect: '/home'
    }, {
        path: '/home',
        component: MainPage
    }, {
        path: '/write',
        component: WriteReview,
        name: 'writeReview',
        props: true
    }, {
        path: '/review',
        name: 'review',
        component: ViewReview,
        props: true
    }, {
        path: '/review/modify',
        name: 'modify',
        component: ModifyReview,
        props: true
    }, {
        path: '/register',
        component: RegisterPage
    }, {
        path: '/login',
        component: LoginPage
    }, {
        path: '/register_album',
        component: RegisterAlbum
    }, {
        path: '/search_album',
        component: SearchAlbum
    }, {
        path: '/logout',
        component: LogoutPage
    }
    ]
});