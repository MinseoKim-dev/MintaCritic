import Vue from 'vue';
import VueRouter from 'vue-router';
import MainPage from '@/components/MainPage';
import WriteReview from "@/components/WriteReview";

Vue.use(VueRouter);

export default new VueRouter({
    mode:'history', //해쉬값 제거 방식
    routes: [{
        path: '/',
        redirect: '/home'
    }, {
        path: '/home',
        component: MainPage
    }, {
        path: '/write',
        component: WriteReview
    }]
});